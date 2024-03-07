package study.ldap.util;

import lombok.Data;

/**
 * @author sun yang
 * @date 2024/1/18
 */
@Data
public class TestUser {

    private Long userId;

    @SysColumn(columnName = "user_name")
    private String userName;

    private String address;

    @SysColumn(columnName = "mobile")
    private String phone;

}
