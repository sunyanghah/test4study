package test.tonglink.web;

import lombok.Data;

/**
 * Created by dell on 2018/8/7.
 * @author dell
 */
@Data
public class HttpResult {

    private boolean isSuccess;

    private Integer status;

    private String responseString;
}
