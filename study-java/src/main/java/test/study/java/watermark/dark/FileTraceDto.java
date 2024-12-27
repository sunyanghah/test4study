package test.study.java.watermark.dark;

import lombok.Data;

/**
 * @author sun yang
 * @date 2023/12/7
 */
@Data
public class FileTraceDto {

    /**
     * ("用户名")
     */
    private String nickName;

    /**
     *  "电子邮箱"
     */
    private String email;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 所属组织
     */
    private String deptName;

    /**
     * 工号
     */
    private String employeeNumber;

    /**
     * 下载时间
     */
    private String downloadTime;

    /**
     * 下载设备
     */
    private String deviceName;
}
