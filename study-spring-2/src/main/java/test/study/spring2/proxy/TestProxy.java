package test.study.spring2.proxy;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2020/5/16.
 * @author dell
 */
@Aspect
@Component
@Slf4j
public class TestProxy {

    @Pointcut("execution(* test.study.spring2.service.*.*(..))")
    private void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        long start = System.currentTimeMillis();
        Object rt = null;
        try {
            rt = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间："+(end - start));
        return rt;
    }

    @Around(value = "@annotation(hikInterface)")
    public void testAround(ProceedingJoinPoint proceedingJoinPoint,HikInterface hikInterface) throws Throwable{
        log.info(hikInterface.desc() + "-----" + JSON.toJSONString(proceedingJoinPoint.getArgs()));
        Object proceed = proceedingJoinPoint.proceed();
        Thread.sleep(4000);
        log.info(JSON.toJSONString(proceed));
    }

}
