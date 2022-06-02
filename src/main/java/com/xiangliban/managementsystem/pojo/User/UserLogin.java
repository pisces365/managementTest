package com.xiangliban.managementsystem.pojo.User;

import lombok.Data;

/**
 * @Author: 张坤
 * @DateTime: 2021/8/23 16:17
 * @Description: 该类用于 TODO
 */
@Data
public class UserLogin {
    /**
     * 用户id
     */
    private Integer u_id;

    /**
     * 用户角色id
     */
    private Integer u_role_id;

    /**
     * 用户密码
     */
    private String u_password;

    /**
     * 用户姓名
     */
    private String u_true_name;

    /**
     * 用户昵称
     */
    private String u_nickname;

    /**
     * 用户头像的url地址
     */
    private String u_avatar_url;

    public UserLogin(Integer u_id, Integer u_role_id, String u_password, String u_true_name, String u_nickname, String u_avatar_url) {
        this.u_id = u_id;
        this.u_role_id = u_role_id;
        this.u_password = u_password;
        this.u_true_name = u_true_name;
        this.u_nickname = u_nickname;
        this.u_avatar_url = u_avatar_url;
    }

    public UserLogin() {
        this.u_id = -1;
        this.u_role_id = -1;
        this.u_password = "u_password";
        this.u_true_name = "u_true_name";
        this.u_nickname = "u_nickname";
        this.u_avatar_url = "u_avatar_url";
    }
}
