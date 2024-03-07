package test.study.java.watermark;

import lombok.Data;

import java.util.List;

/**
 * @author sun yang
 * @date 2023/12/7
 */
@Data
public class OutFileTraceVo {

    /**
     * ("文件名")
     */
    private String fileName;

    /**
     * ("文件溯源信息")
     */
    private List<FileTraceDto> traceList;

}
