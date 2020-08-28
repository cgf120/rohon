package cn.rohon.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

public interface RohonBaseHandleInterceptor extends HandlerInterceptor {
    /**
     * 拦截范围，默认拦截所有
     * @return
     */
    String[] getPathPatterns();

    /**
     * 忽略范围，默认所有都不忽略
     * @return
     */
    String[] getExcludePathPatterns();
}
