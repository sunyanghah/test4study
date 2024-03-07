package test.study.java.watermark;

import java.text.MessageFormat;

/**
 * <b>请输入名称</b>
 * <p>
 * 描述<br/>
 * 作用：；<br/>
 * 限制：；<br/>
 * </p>
 *
 * @author jiangdq(71006)
 * @date 2022/8/4 15:56
 */
public enum BusinessResponseEnum {

    MARK_ERROR(100201,"加水印失败"),

    UN_MARK_ERROR(100202,"获取水印失败")

    ;
    /**
     * 响应错误码
     */
    private int code;

    /**
     * 响应日志
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    BusinessResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RuntimeException newException(Object... args) {
        String msg = MessageFormat.format(getMsg(), args);
        return new RuntimeException(msg);
    }

}
