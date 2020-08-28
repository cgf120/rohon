package cn.rohon.config;

import cn.rohon.annotation.RohonHandlerInterceptor;
import cn.rohon.interceptor.RohonBaseHandleInterceptor;
import cn.rohon.interceptor.UserHandlerInterceptor;
import cn.rohon.utils.SpringContextUtil;
import cn.rohon.utils.StringUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cgf_p
 *拦截器配置
 */
@Configuration
public class RohonWebMvcConfigurationSupport extends WebMvcConfigurationSupport {
    @Resource
    UserHandlerInterceptor userHandlerInterceptor;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        Map<String, RohonBaseHandleInterceptor> beans = SpringContextUtil.getBeanOfType(RohonBaseHandleInterceptor.class);
        for (String key: beans.keySet()) {
            RohonBaseHandleInterceptor interceptor = beans.get(key);
            registry.addInterceptor(interceptor)
                    .addPathPatterns(StringUtil.isEmpty(interceptor.getPathPatterns()) ? Arrays.asList("/**") : Arrays.asList(interceptor.getPathPatterns()))
                    .excludePathPatterns(StringUtil.isEmpty(interceptor.getExcludePathPatterns()) ? Arrays.asList("") : Arrays.asList(interceptor.getExcludePathPatterns()));
        }
        super.addInterceptors(registry);
    }
}
