package test.study.spring1.annotation;

import java.lang.annotation.*;

/**
 * Created by dell on 2019/6/24.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyMapper {
}
