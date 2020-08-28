package cn.rohon.interceptor;

import cn.rohon.config.Const;
import cn.rohon.exception.MyException;
import cn.rohon.exception.MyExceptionEnum;
import cn.rohon.utils.RohonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author cgf_p
 */
@Component
public class UserHandlerInterceptor implements RohonBaseHandleInterceptor {
    static private final Logger logger = LoggerFactory.getLogger(UserHandlerInterceptor.class);

    @Resource
    RedisTemplate<String, Object> redisTemplate;
    /**
     * 登陆信息只从缓存取，登陆时候缓存，其他请求缓存获取
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if(!StringUtils.isEmpty(token) && redisTemplate.hasKey(Const.TOKEN_SUFIX + token)){
            redisTemplate.expire(Const.ENTITY_USER + ":" + request.getHeader("token"),Const.TOKEN_LIMIT_TIME, TimeUnit.MILLISECONDS);
            return true;
        }else{
            try {
                response.sendRedirect(RohonUtils.getHost(request) + "loginError/loginError?title=获取用户科室信息失败");
            } catch (IOException e) {
                throw new MyException(MyExceptionEnum.SYSTEM_PARAM);
            }
            return false;
        }
    }

    @Override
    public String[] getPathPatterns() {
        return new String[]{"/api/**"};
    }

    @Override
    public String[] getExcludePathPatterns() {
        return new String[0];
    }
}
