package test.study.spring2.proxy;

import java.lang.annotation.*;

/**
 * Created by dell on 2019/7/22.
 * sqlite查询语句重试。注意：此
 * @author dell
 */
@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HikInterface {

    String desc();

}
