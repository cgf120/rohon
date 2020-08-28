package cn.rohon.config;

/**
 * @author cgf_p
 */
public class Const {
    public static final String TOKEN_SUFIX = "rohon:token:";

    public static final String ENTITY_USER = "rohon:entityUser:";

    public final static String CAPTCHA_HEADER_KEY = "Captcha-Key";
    public final static String CAPTCHA_HEADER_CODE = "Captcha-Code";
    public final static String USER_TYPE_HEADER_KEY = "User-Type";
    public final static String HEADER_KEY = "Authorization";
    public final static String HEADER_PREFIX = "Basic ";
    public static final long TOKEN_LIMIT_TIME = 4 * 60 * 60 * 1000;
}