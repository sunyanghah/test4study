//package test.study.spring1.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import test.study.spring1.entity.Boss;
//import test.study.spring1.entity.Empy;
//import test.study.spring1.mapper.BossMapper;
//import test.study.spring1.mapper.EmpyMapper;
//import test.study.spring1.service.TransactionService;
//
///**
// * Created by dell on 2019/10/14.
// * @author dell
// */
//@Service
//public class TransactionServiceImpl implements TransactionService{
//
//    @Autowired
//    private BossMapper bossMapper;
//
//    @Autowired
//    private EmpyMapper empyMapper;
//
//
//    @Override
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
//    public void test() throws Exception{
//        insert1();
//        insert2();
//        System.out.println(1/0);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NEVER)
//    public void insert1() throws Exception{
//        Boss boss = new Boss();
//        boss.setName("aaa");
//        boss.setAge(111);
//        bossMapper.insert(boss);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void insert2() throws Exception{
//        Empy empy = new Empy();
//        empy.setName("AAA");
//        empy.setBalance("AAA");
//        empyMapper.insert(empy);
//    }
//
//
//}
