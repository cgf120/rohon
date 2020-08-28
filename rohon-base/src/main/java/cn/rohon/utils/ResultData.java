package cn.rohon.utils;

import cn.rohon.base.EntityBase;
import cn.rohon.annotation.TransferParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * @Author:cuigaofeng
 * @Date:Created in 22:31 2020/7/21
 */
@JsonInclude(JsonInclude.Include.NON_NULL)	//注解控制null不序列化
@Data
public class ResultData<T> {
    private boolean success;
    private String msg;
    private T data;

    public static ResultData converResullt(boolean success, String msg) {
        return converResullt(success,msg,null);
    }

    public static ResultData converResullt(boolean success, String msg, Object data) {
        ResultData map = new ResultData();
        map.setSuccess(success);;
        map.setMsg(msg);

        if(data!=null && data.getClass().getSuperclass().isAssignableFrom(EntityBase.class)){
            //过滤调不需要返回前端的数据
            Field[] fields = data.getClass().getDeclaredFields();
            for (int i = 0; i <fields.length; i++) {
                if(fields[i].getAnnotationsByType(TransferParam.class).length > 0){
                    fields[i].setAccessible(true);
                    try {
                        fields[i].set(data,null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        map.setData(data);
        return map;
    }
}
