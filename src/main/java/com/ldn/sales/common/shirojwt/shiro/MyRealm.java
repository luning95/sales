package com.ldn.sales.common.shirojwt.shiro;

import com.auth0.jwt.JWT;
import com.ldn.sales.common.shirojwt.database.UserBean;
import com.ldn.sales.common.shirojwt.database.UserService;
import com.ldn.sales.common.shirojwt.util.JWTUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * realm的用于处理用户是否合法的这一块，需要我们自己实现。
 */
@Service
public class MyRealm extends AuthorizingRealm {
    private static final Logger logger = LogManager.getLogger(MyRealm.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }


    /**
     * 权限认证:
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JWTUtil.getUsername(principalCollection.toString());
        /**
         * 获取用户信息:
         * 利用 token 中获得的 username，分别从数据库查到该用户所拥有的角色，权限，
         * 存入 SimpleAuthorizationInfo 中
         */
        UserBean userBean = userService.getUser(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        /**用户角色设置添加*/
        simpleAuthorizationInfo.addRole(userBean.getRole());
        /**用户权限设置添加*/
        Set<String> permission = new HashSet<>(Arrays.asList(userBean.getPermission().split(",")));
        simpleAuthorizationInfo.addStringPermissions(permission);
    /*   //也可以：将 role, permission 封装到 Set 作为 info.setRoles(),
        // info.setStringPermissions() 的参数
       //setRoles(Set<String> roles)；
        simpleAuthorizationInfo.setRoles();
        //  public void setStringPermissions(Set<String> stringPermissions)
        simpleAuthorizationInfo.setStringPermissions();*/
        return simpleAuthorizationInfo;
    }

    /**
     * 证明：
     *获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        UserBean userBean = userService.getUser(username);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, username, userBean.getPassword())) {
            //token认证失败！
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
