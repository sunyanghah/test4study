package test.study.fastdfs.config;

import lombok.Getter;

/**
 * 错误码-描述 枚举
 * @author sunYang
 * @date 2021/9/17 17:22
 */
@Getter
public enum DevelopmentValueTypeE {

    /**
     * 错误码与描述，
     */

    FILE(1),
    IMAGE(2),

    VIDEO(3),
    FOLDER(4)
    ;

    /**
     * 错误码
     */
    @Getter
    private final Integer code;

    /**
     * @param code 错误码
     */
    DevelopmentValueTypeE(final Integer code) {
        this.code = code;
    }
}
