package test.security.jwt.config.err;

public enum BasicErrorCode implements ErrorCodeI {

    SUCCESS("200", "SUCCESS"),
    BIZ_ERROR("BIZ_ERROR", "业务逻辑错误(Business error)"),
    SYS_ERROR("SYS_ERROR", "系统错误(System error)"),
    ERROR("ERROR", "未知错误(Unknown error)");

    private final String errCode;
    private final String errMessage;

    private BasicErrorCode(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMessage() {
        return this.errMessage;
    }

}
