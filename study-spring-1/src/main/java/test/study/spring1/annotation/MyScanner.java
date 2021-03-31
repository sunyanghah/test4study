package test.study.spring1.annotation;

import org.springframework.context.annotation.Import;
import test.study.spring1.config.MyScannerRegistrar;

import java.lang.annotation.*;

/**
 * Created by dell on 2019/6/24.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MyScannerRegistrar.class)
public @interface MyScanner {

    String basePackage();

}
