package test.study.spring1.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sunYang
 * @date 2023/2/8 17:04
 */
@Slf4j
@Component
public class TestChildFilter extends TestFilter{

    @Override
    protected void show(){
        System.out.println("===============sdfsdfsdfsdfsdfada");
    }

}
