package test.study.java.mianshiti2024;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Map;

/**
 * @author sun yang
 * @date 2024/1/10
 */
@Data
public class OutConfigDownloadVo {

    private Long packageId;

    @JsonIgnore
    private Map pageConf;

    @JsonAnyGetter
    public Map getPageConf() {
        return pageConf;
    }
}
