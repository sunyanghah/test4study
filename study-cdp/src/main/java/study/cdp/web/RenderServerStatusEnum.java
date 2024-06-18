package study.cdp.web;

/**
 * 渲染服务状态
 */
public enum RenderServerStatusEnum {
    /**
     * 未启动
     */
    NOT_STARTED("not_started"),

    /**
     * 运行中
     */
    RUNNING("running"),

    /**
     * 已退出
     */
    QUIT("quit");

    private final String status;

    RenderServerStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
