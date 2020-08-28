package cn.rohon.exception;

public enum MyExceptionEnum {
    /** 参数异常 */
    SYSTEM_PARAM("100001", "系统发生异常，请联系管理员！"),
    /** 参数异常 */
    SERVICE_TIME_OUT("100002", "服务调用超时"),
    ParseException("20000", "解析错误！");

    /**
     * 消息码
     */
    private String code;
    /**
     * 消息内容
     */
    private String msg;

    MyExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
