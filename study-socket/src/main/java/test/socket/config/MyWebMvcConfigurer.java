package test.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunYang
 * @date 2021/12/23 16:58
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String filePath = FilePathUtil.getFilePath();
        registry.addResourceHandler("/staticResource/**").addResourceLocations("file:"+filePath+"/");
    }

}
