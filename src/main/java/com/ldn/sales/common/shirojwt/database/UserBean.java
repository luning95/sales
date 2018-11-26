package com.ldn.sales.common.shirojwt.database;

import lombok.Data;

/**
 * 每个用户有对应的角色（user，admin），
 * 权限分 view,edit（normal，vip），
 * 而 user 角色默认权限为 normal，
 * admin 角色默认权限为vip（user 也可以是 vip）
 */
@Data
public class UserBean {
    private String username;
    private String password;
    //role: 角色；
    private String role;
    //permission: 权限；
    private String permission;
    //ban: 封号状态
    private String ban;

}

