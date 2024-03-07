package test.socket.config;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by dell on 2018/10/27.
 * @author dell
 */
@Data
public class RP<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(
            ordinal = 2
    )
    private String status = "success";
    @JSONField(
            ordinal = 3
    )
    private String message = "";
    @JSONField(
            ordinal = 4
    )
    private String timestamp = String.valueOf(System.currentTimeMillis());
    @JSONField(
            ordinal = 5
    )
    private T data;

    public RP() {
    }

    public RP(String status, String msg, T data) {
        this.status = status;
        this.message = msg;
        this.data = data;
    }

    public static <T> RP<T> buildSuccess(String msg, T data) {
        return new RP<T>("success", msg, data);
    }

    public static <T> RP<T> buildFail(String msg){
        return new RP<T>("fail", msg, null);
    }

}
