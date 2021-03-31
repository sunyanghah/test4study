package test.study.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.study.news.entity.Test;
import test.study.news.mapper.TestMapper;
import test.study.news.service.TestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() throws Exception {
        List<Test> testList = new ArrayList<>();
        for (int i=0;i<100;i++){
            if (i>0 && i%10 ==0){
                add(testList);
                testList.clear();
            }
            Test test = new Test();
            test.setName(i+"");
            testList.add(test);
        }
    }

    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public void add(List<Test> testList){
        this.saveBatch(testList);
    }

}
