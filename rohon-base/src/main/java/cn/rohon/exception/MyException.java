package cn.rohon.exception;

/**
 * <h3>springboot-study</h3>
 * <p>业务异常提示信息枚举类</p>
 * @author : zhang.bw
 * @date : 2020-07-17 21:37
 **/
public class MyException extends  RuntimeException {

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常提示信息
     */
    private String message;

    public MyException(MyExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.code();
        this.message = exceptionEnum.msg();
    }
}
