package study.cdp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sun yang
 * @date 2024/3/15
 */

@ConfigurationProperties("rbi")
@Data
@Component
public class RbiConfigProperties {

    private String host;

    private String portRange;

    private String userDataDir;

    private String metaDir;

}
