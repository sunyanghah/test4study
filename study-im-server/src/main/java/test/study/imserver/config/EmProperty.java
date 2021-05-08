package test.study.imserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sunYang
 * @Date 2021-04-15
 */
@ConfigurationProperties(prefix = "em")
@Data
@Component
public class EmProperty {

    private String appKey;

    private String clientId;

    private String clientSecret;

}
