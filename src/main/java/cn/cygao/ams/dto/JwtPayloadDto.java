package cn.cygao.ams.dto;

import lombok.Data;

/**
 * jwt token payload字段DTO
 *
 * @author STEA_YY
 **/
@Data
public class JwtPayloadDto {
    /**
     * 账号
     */
    private Integer account;
    /**
     * 角色名称
     */
    private String roleName;
}
