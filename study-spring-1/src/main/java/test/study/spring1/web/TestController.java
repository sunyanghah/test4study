package test.study.spring1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.spring1.dto.BeanTest;
import test.study.spring1.service.MyService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@RestController
public class TestController {

    @Autowired
    private MyService myService;
    @Resource(name = "bean1")
    private BeanTest beanTest1;
    @Resource(name = "bean2")
    private Map beanTest2;
    @Resource(name = "bean3")
    private BeanTest beanTest3;


    @GetMapping("/test")
    public void test() {
        myService.test();
    }

    @GetMapping("/test/teacher")
    public void testTeacher() {
        myService.testTeacher();
    }

    @GetMapping("/test-bean")
    public void testBean(){
        System.out.println("-----------------");
    }

    public static void main(String[] args){
        String str = "a,bc,d,fff,";
        System.out.println(str.length());

        if (str.endsWith(",")){
            str = str.substring(str.length());
        }
        System.out.println(str.charAt(str.length()));
        System.out.println(str);
    }
}
