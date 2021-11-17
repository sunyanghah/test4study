package test.study.shiro4.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "auth")
@Data
public class AuthProperties {

    private Integer expireHour;

    private List<String> whiteList;

}
