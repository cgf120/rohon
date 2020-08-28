package cn.rohon.utils;

import javax.servlet.http.HttpServletRequest;

public class RohonUtils {
    public static String getHost(HttpServletRequest request){
        StringBuffer url = request.getRequestURL();

        return url.substring(0,url.lastIndexOf(":")+1) + "8037/";
    }
}
