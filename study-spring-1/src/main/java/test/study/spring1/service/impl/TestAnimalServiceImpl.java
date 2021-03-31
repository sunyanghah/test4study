package test.study.spring1.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import test.study.spring1.service.TestServiceExtendService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author sunYang
 * @Date 2021-03-27
 */
@Service
@Primary
public class TestAnimalServiceImpl implements TestServiceExtendService {

    @Override
    public String getInfo() {
        Map<Integer, Callable<String>> map = new HashMap<>();
        map.put(1, this::getCatInfo);
        map.put(2, this::getDogInfo);
        try {
            return map.get(2).call();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void otherMethod() {

    }

    private String getCatInfo(){
        return "cat cat";
    }

    private String getDogInfo(){
        return "dog dog";
    }

}
