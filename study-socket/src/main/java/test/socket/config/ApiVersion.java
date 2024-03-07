package test.socket.config;

import java.lang.annotation.*;

/**
 * @author sunyang
 * @date 2023-11-17
 * @desc
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ApiVersion {
    int value();
}
