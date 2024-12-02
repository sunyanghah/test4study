package test.study.java.mianshiti2024;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * 组织、用户类型枚举
 * @author 孙杨
 * @date 2023/12/4
 */
@Getter
public enum DeptUserTypeEnum {
    /**
     * 系统自建
     */
    SYS("00"),

    /**
     * LDAP同步
     */
    LDAP("01"),

    /**
     * 飞书同步
     */
    FEI_SHU("02"),

    /**
     * 钉钉
     */
    DING_TALK("03"),

    /**
     * 企业微信
     */
    WORK_WX("04");

    private final String flag;

    DeptUserTypeEnum(String flag) {
        this.flag = flag;
    }

    public static DeptUserTypeEnum of(String flag){
        return Stream.of(DeptUserTypeEnum.values())
                .filter(e -> e.flag.equals(flag))
                .findFirst()
                .orElse(SYS);
    }

}
