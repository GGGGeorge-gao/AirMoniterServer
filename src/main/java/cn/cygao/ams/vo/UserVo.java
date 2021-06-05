package cn.cygao.ams.vo;

import cn.cygao.ams.entity.Role;
import cn.cygao.ams.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户私有信息VO
 *
 * @author STEA_YY
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Integer id;

    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 账户首次登录时间
     */
    private Date createdTime;

    /**
     * 用户角色
     */
    private Role role;

    public static UserVo buildVo(User user) {
        return UserVo.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .createdTime(user.getCreatedTime())
                .build();
    }
}
