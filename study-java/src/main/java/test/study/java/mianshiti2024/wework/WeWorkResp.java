package test.study.java.mianshiti2024.wework;

import lombok.Data;

/**
 * @author sun yang
 * @date 2024/7/24
 */
@Data
public class WeWorkResp {

    private Integer errcode;

    private String errmsg;

    public boolean isSuccess(){
        return errcode == 0;
    }

}
