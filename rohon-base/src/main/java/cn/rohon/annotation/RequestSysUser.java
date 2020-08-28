package cn.rohon.annotation;

import java.lang.annotation.*;

/**
 * @author cgf_p
 * <p>
 * 系统用户拦截的结果变量，通过token获取到系统用户的实体
 * <p>
 * 调用方式 @ApiIgnore @RequestSysUser EntitySysUser eSysUser
 *
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestSysUser {
    String value() default "entitySysUser";
}
