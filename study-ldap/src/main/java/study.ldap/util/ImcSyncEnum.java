package study.ldap.util;

/**
 * @author sun yang
 * @date 2024/1/12
 */
public enum ImcSyncEnum {

    LOGIN_TYPE("loginType");
    private String code;

    ImcSyncEnum(String code) {
        this.code = code;
    }

    public class IsSslConnect {
        public static final String YES = "1";
        public static final String NO = "0";
    }

    public class SyncSourceType {
        public static final String LDAP = "1";
        public static final String AD = "0";
    }

    public class SyncEntityType{
        public static final String ORG = "org";
        public static final String USER = "user";
    }

}
