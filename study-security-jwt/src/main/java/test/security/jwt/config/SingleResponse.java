package test.security.jwt.config;

import lombok.Data;
import test.security.jwt.config.err.BasicErrorCode;
import test.security.jwt.config.err.ErrorCodeI;

@Data
public class SingleResponse<T> {
    private String errCode;
    private String errMessage;
    private T data;


    public SingleResponse() {
    }

    public static <T> SingleResponse<T> of(String errCode, String errMessage, T data) {
        SingleResponse<T> singleResponse = new SingleResponse();
        singleResponse.setErrCode(errCode);
        singleResponse.setErrMessage(errMessage);
        singleResponse.setData(data);
        return singleResponse;
    }

    public static <T> SingleResponse<T> of(ErrorCodeI errorCode, T data) {
        return of(errorCode.getErrCode(), errorCode.getErrMessage(), data);
    }

    public static <T> SingleResponse<T> success(T data) {
        return of(BasicErrorCode.SUCCESS, data);
    }

    public static SingleResponse<?> success() {
        return of(BasicErrorCode.SUCCESS, (Object)null);
    }

    public static <T> SingleResponse<T> failure(T data) {
        return of(BasicErrorCode.ERROR, data);
    }

    public static <T> SingleResponse<T> failure(ErrorCodeI errorCode, T data) {
        return of(errorCode, data);
    }

    public static <T> SingleResponse<T> failure(String errCode, String errMessage, T data) {
        return of(errCode, errMessage, data);
    }

    public String toString() {
        return "SingleResponse(data=" + this.getData() + ")";
    }
}
