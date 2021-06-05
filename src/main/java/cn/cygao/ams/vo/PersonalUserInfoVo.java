package cn.cygao.ams.vo;

import cn.cygao.ams.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 登录用户获取个人信息DTO
 *
 * @author STEA_YY
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonalUserInfoVo {
    private Integer userId;

    private String username;

    /**
     * 用户角色
     */
    private Role role;

    private Date createdTime;

}
