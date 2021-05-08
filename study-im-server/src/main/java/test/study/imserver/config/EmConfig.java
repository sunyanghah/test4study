package test.study.imserver.config;

import com.easemob.im.server.EMProperties;
import com.easemob.im.server.EMService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @Date 2021-04-15
 */
@ConditionalOnClass(EMService.class)
@Configuration
public class EmConfig {

    @Resource
    private EmProperty emProperty;

    @Bean
    public EMProperties getEMProperties(){
        EMProperties properties = EMProperties.builder()
                .setAppkey(emProperty.getAppKey())
                .setClientId(emProperty.getClientId())
                .setClientSecret(emProperty.getClientSecret())
                .build();
        return  properties;
    }

    @Bean
    public EMService getEMService(){
        EMService service = new EMService(getEMProperties());
        return service;
    }

}
