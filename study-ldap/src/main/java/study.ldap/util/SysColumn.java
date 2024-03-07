package study.ldap.util;

import java.lang.annotation.*;

/**
 * @author sun yang
 * @date 2024/1/18
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysColumn {

    String columnName();

}
