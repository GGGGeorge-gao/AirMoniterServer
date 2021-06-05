package cn.cygao.ams.config;

import cn.cygao.ams.interceptor.CrossInterceptor;
import cn.cygao.ams.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 鉴权拦截器的配置类
 *
 * @author STEA_YY
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private AuthenticationInterceptor authenticationInterceptor;
    @Resource
    private CrossInterceptor crossInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(crossInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/**");
    }
}