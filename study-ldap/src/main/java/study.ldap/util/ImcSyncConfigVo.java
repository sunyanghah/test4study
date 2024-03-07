package study.ldap.util;

import lombok.Data;

/**
 * @author sun yang
 * @date 2024/1/12
 */
@Data
public class ImcSyncConfigVo {

    private String baseDn;

    private String adminDn;

    private String adminPwd;

    private String url;

    private String port;

    private String entityType;

    private String sourceType;

    private String isSslConnect;

}
