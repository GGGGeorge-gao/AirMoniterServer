package cn.cygao.ams.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author cygao
 * @date 2021/6/3
 **/
@Data
public class LoginUserDto {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$", message = "密码至少包含数字和英文，长度6-16")
    @Size(min = 8, max = 16, message = "密码长度必须在8-16位之间")
    private String password;
}
