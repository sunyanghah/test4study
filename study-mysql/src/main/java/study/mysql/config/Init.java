package study.mysql.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import study.mysql.service.IFieldInfoService;

import javax.annotation.Resource;

/**
 * @author sun yang
 * @date 2024/3/6
 */
@Service
public class Init implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private IFieldInfoService fieldInfoService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        fieldInfoService.init();
    }
}
