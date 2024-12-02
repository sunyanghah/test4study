package test.study.java.mianshiti2024.wework;

import lombok.Data;

/**
 * @author sun yang
 * @date 2024/7/24
 */
@Data
public class WeWorkTokenDto extends WeWorkResp{

    private String access_token;

    private Integer expires_in;

}
