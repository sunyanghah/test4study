package test.study.spring1.dto;

import org.springframework.stereotype.Component;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@Component
public class Student {

    private String name;

    private Integer age;

    public void talk(){
        System.out.println("i am a student");
    }

}
