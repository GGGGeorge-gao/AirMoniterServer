package cn.cygao.ams.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 *
 * @author cygao
 * @date 2021/6/3
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户创建时间
     */
    private Date createdTime;

    /**
     * 权限id
     */
    private Integer roleId;
}