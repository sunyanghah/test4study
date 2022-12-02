package test.study.spring1.web;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunYang
 * @date 2022/4/2 11:12
 */
@RestController
@RequestMapping("/test/thread")
public class TestThreadController {

    @Resource
    private ThreadPoolTaskExecutor pool;



    @GetMapping
    public void testThread() throws InterruptedException {
        AtomicInteger num = new AtomicInteger();
        long start = System.currentTimeMillis();
        for(int j=0;j<5;j++) {
            final int jj = j;
            CountDownLatch countDownLatch = new CountDownLatch(30);
            for (int i = 0; i < 30; i++) {
                final int ii = i;
                pool.execute(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num.getAndIncrement();
                    System.out.println("---------->Thread:"+Thread.currentThread().getName()+"---"+jj+"--"+ii);
                    countDownLatch.countDown();
                });
//                System.out.println("out======="+jj+"--"+ii);
            }
            countDownLatch.await();
        }

        System.out.println("===down==="+((System.currentTimeMillis()-start)/1000)+"=================num:"+num);

    }


}
