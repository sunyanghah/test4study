package test.study.java.watermark.dark;

import lombok.Data;

/**
 * @author sun yang
 * @date 2023/12/7
 */
@Data
public class FileTraceDeviceDto {

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 状态
     */
    private String status;

    /**
     * 最近登录IP
     */
    private String ip;

    /**
     * mac
     */
    private String mac;

    /**
     * 客户端版本
     */
    private String deviceVersion;

    /**
     * 操作系统版本
     */
    private String osVersion;

    /**
     * 下载来源
     */
    private String downloadSource;

    /**
     * 下载时间
     */
    private String downloadTime;

}
