package cn.cygao.ams.constants;

/**
 * Redis相关常量类
 *
 * @author STEA_YY、cygao、Qin Zhenghan
 **/
public class RedisConstants {
    /**
     * 注册短信验证码Redis前缀
     */
    public static final String REGISTER_MESSAGE_CODE_PREFIX = "user:register:code:";

    /**
     * 修改密码短信验证码Redis前缀
     */
    public static final String CHANGE_PASSWORD_MESSAGE_CODE_PREFIX = "user:changePassword:code:";

    /**
     * 绑定手机号短信验证码Redis前缀
     */
    public static final String BIND_PHONE_MESSAGE_CODE_PREFIX = "user:bindPhone:code:";

    /**
     * RefreshToken Redis前缀
     */
    public static final String REFRESH_TOKEN_PREFIX = "user:token:";

    /**
     * 用户阅读项目标记 Redis前缀
     */
    public static final String USER_PROJECT_READ_PREFIX = "user:project:read:";

    /**
     * 请求限制 Redis前缀
     */
    public static final String REQUEST_LIMIT_PREFIX = "request:limit:";

    public static final String ACTIVITY_CODE_COUNT_PREFIX = "activity:code:count:";

    public static final String ACTIVITY_CODE_PREFIX = "activity:code:";

    public static final String PROJECT_UPLOAD_TEMP_TOKEN_PREFIX = "project:upload:token:";


}
