package test.study.java.mianshiti2024.wework;

import lombok.Data;

import java.util.List;

/**
 * @author sun yang
 * @date 2024/7/24
 */
@Data
public class WeWorkUserDto extends WeWorkResp {

    private List<WeWorkUser> userlist;

}
