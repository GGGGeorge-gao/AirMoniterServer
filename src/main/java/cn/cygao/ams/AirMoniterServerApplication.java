package cn.cygao.ams;

import cn.cygao.ams.config.JwtConfig;
import cn.cygao.ams.config.UserOperationLogConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author cygao
 */
@EnableConfigurationProperties({JwtConfig.class, UserOperationLogConfig.class})
@MapperScan(basePackages = "com.cygao.ams.mapper")
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class AirMoniterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirMoniterServerApplication.class, args);
    }

}
