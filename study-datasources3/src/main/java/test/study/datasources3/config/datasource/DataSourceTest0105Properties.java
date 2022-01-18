package test.study.datasources3.config.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sunYang
 * @date 2022/1/18 10:49
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.test0105")
public class DataSourceTest0105Properties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
