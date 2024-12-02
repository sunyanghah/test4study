package test.study.java.mianshiti2024;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sun yang
 * @date 2024/11/19
 */
@Slf4j
public class Test1119 {

    public static void main(String[] args) {
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            log.error("error", e);
        }
    }

}
