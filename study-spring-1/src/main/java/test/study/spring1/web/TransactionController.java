package test.study.spring1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.spring1.service.TransactionService;

import java.util.Map;

/**
 * Created by dell on 2019/10/14.
 * @author dell
 */
@RestController
@RequestMapping("/testTransaction")
public class TransactionController {

//    @Autowired
//    private TransactionService transactionService;

//    @GetMapping("/test1")
//    public Map<String,Object> test1() throws Exception{
//        transactionService.test();
//        return null;
//    }

}
