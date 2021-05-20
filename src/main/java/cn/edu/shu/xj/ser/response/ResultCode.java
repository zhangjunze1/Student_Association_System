package cn.edu.shu.xj.ser.response;

public enum ResultCode implements CustomizeResultCode{
    /**
     * 20000 成功
     */
    SUCCESS(20000,"成功"),
    /**
     * 20001 失败
     */
    ERROR(20001,"失败"),
    /**
     *  401:jwt出错
     */
    JWT_WRONG(401, "JWT出错"),
    /**
     *  404:没有找到对应的请求路径
     */
    PAGE_NOT_FOUND(404, "你要请求的页面好像暂时飘走了...要不试试请求其它页面?"),
    /**
     *  500:服务端异常
     */
    INTERNAL_SERVER_ERROR(500, "服务器冒烟了...要不等它降降温后再来访问?"),
    /**
     * 3001:"算数异常"
     */
    ARITHMETIC_EXCEPTION(3001,"算数异常"),
    /**
     * 3011:"无token，请重新登录"
     */
    NO_TOKEN(3011,"无token，请重新登录"),
    /**
     * 3012:"该学号尚未有用户注册"
     */
    NO_USER(3012,"该学号尚未有用户注册"),
    /**
     * 3013:"用户输入密码错误"
     */
    ERROR_USER_PWD(3013,"用户输入密码错误"),
    /**
     * 3014:"学号被占用"
     */
    USER_REGISTER_REPEAT(3014,"学号被占用"),
    /**
     * 3015:"密码注册不相同"
     */
    USER_PWD_DIFFERENT(3015,"密码注册两次输入不相同"),
    /**
     * 3016:"性别不能为空"
     */
    USER_GENDER_NULL(3016,"性别不能为空"),
    /**
     * 3017:"用户注册失败"
     */
    ERROR_USER_REGISTER(3017,"用户注册失败"),
    /**
     * 3018:"用户密码输入错误"
     */
    ERROR_PWD(3018,"用户密码输入错误"),
    /**
     * 3019:"当前没有任何用户使用本软件"
     */
    NO_USER_AUTHORITY(3019,"当前没有任何用户使用本软件"),
    /**
     * 3020:"没有参加任何社团，参加社团数量为零"
     */
    MY_ASS_IS_EMPTY(3020,"没有参加任何社团，参加社团数量为零"),
    /**
     * 3021:"没有参加任何社团，参加社团数量为零"
     */
    ASS_ACTIVITY_IS_EMPTY(3021,"没有参加任何社团，参加社团数量为零"),
    /**
     *  2001:未知异常
     */
    UNKNOW_SERVER_ERROR(2001, "未知异常,请联系管理员!");





    private Integer code;

    private String message;

    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
