package cn.cygao.ams.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * 用户行为日志配置类
 *
 * @author STEA_YY
 **/
@ConfigurationProperties("user-operation-log")
@Data
public class UserOperationLogConfig {
    private String format;

    public static String FORMAT;

    @PostConstruct
    public void setFormat() {
        FORMAT = format;
    }
}
