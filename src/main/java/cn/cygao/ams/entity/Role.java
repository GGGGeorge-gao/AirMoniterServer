package cn.cygao.ams.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限表
 *
 * @author cygao
 * @date 2021/6/3
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;

    /**
     * 权限名
     */
    private String name;
}