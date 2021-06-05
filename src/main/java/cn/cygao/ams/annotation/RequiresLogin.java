package cn.cygao.ams.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要鉴权的注解
 *
 * @author cygao
 * @date 2021/6/3
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresLogin {
    boolean required() default true;

    boolean requireSignNotice() default true;

    boolean requireSignContract() default false;

    boolean requireAuthenticated() default false;

    String[] requiresRoles() default {};
}