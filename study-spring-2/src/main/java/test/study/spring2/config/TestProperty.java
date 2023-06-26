package test.study.spring2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@ConfigurationProperties(prefix = "test")
@Data
public class TestProperty {

    private String name;

    private List<String> nameList;

    private List<Map<String,Map<String,Object>>> ttList;


}
