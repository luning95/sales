package com.ldn.sales.common.shirojwt.controller;

import com.ldn.sales.common.shirojwt.bean.ResponseBean;
import com.ldn.sales.common.shirojwt.database.UserBean;
import com.ldn.sales.common.shirojwt.database.UserService;
import com.ldn.sales.common.shirojwt.util.JWTUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * /login 登入
 * /article 所有人都可以访问，但是用户与游客看到的内容不同
 * /require_auth 登入的用户才可以进行访问
 * /require_role admin的角色用户才可以登入
 * /require_permission 拥有view和edit权限的用户才可以访问
 */

@RestController
//@RequestMapping("shiro")
public class WebController {

    private static final Logger LOGGER = LogManager.getLogger(WebController.class);
    @Autowired
    private UserService userService;


    @PostMapping("login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        UserBean userBean = userService.getUser(username);
        if (userBean.getPassword().equals(password)) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("article")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseBean(200, "You are already logged in", null);
        } else {
            return new ResponseBean(200, "You are guest", null);
        }
    }

    @GetMapping("require_auth")
    @RequiresAuthentication
    public ResponseBean requireAuth() {
        return new ResponseBean(200, "You are authenticated", null);
    }

    /**
     * // 拥有 user 或 admin 角色可以访问
     *
     * @return
     * @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
     */
    @GetMapping("require_role")
    // 拥有 admin 角色可以访问
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "You are visiting require_role", null);
    }

    /**
     * 拥有 user 或 admin 角色，且拥有 vip 权限可以访问---按规则自由组合
     *
     * @return
     * @GetMapping("getVipMessage")
     * @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
     * @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
     */
    @GetMapping("require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ResponseBean requirePermission() {
        return new ResponseBean(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = "401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean unauthorized() {
        return new ResponseBean(401, "Unauthorized：您没有权限访问！", null);
    }
}