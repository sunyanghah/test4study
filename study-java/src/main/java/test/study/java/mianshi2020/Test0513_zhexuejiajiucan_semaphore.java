package test.study.java.mianshi2020;

import java.util.concurrent.Semaphore;

/**
 * @author sunyang
 * @date 2023-10-29
 * @desc
 */
public class Test0513_zhexuejiajiucan_semaphore {

    private static final int numPhilosophers = 5;
    private final Semaphore[] forks = new Semaphore[numPhilosophers];

    /**
     * 在哲学家就餐问题中，每个哲学家需要同时获取其左右两边的筷子才能开始就餐。
     * 但是如果所有哲学家都同时拿起它们左边的筷子，那么它们将无法取得右边的筷子，从而无法就餐。
     * 为了避免这种情况，我们需要限制同时就餐的哲学家数量。如果让所有哲学家都尝试去拿筷子，那么最多只能有4个哲学家同时就餐。
     * 这是因为如果5个哲学家都拿起自己左边的筷子，那么就只剩下一只筷子没有被拿起来。
     * 此时，最多只有4个哲学家可以获取其右边的筷子，而剩下的1个哲学家将无法获取筷子，从而无法就餐。
     * 简而言之，如果他们同时哪起左边的筷子，将造成所有人都没法吃饭，必须要限制有一个人先不吃。
     * 实际上同时在夹菜的人只有两个，但是这里设置4个的原因是，有4个线程在这等待，其中任意两个人吃完后，剩下的人可以最快拿到筷子。
     */
    private final Semaphore maxDiners = new Semaphore(numPhilosophers - 1);

    public Test0513_zhexuejiajiucan_semaphore() {
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    /**
     *
     * @param philosopher 哲学家编号
     * @throws InterruptedException
     */
    public void startEating(int philosopher) throws InterruptedException {
        maxDiners.acquire();

        int leftFork = philosopher;
        /**
         * 这里是为了获取右边的叉子（or fork），一般是一个圆桌上维护的数组，将编号末尾相邻的两个叉子一左一右两两相邻，最后一个叉子是和第一个叉子相邻的。
         */
        int rightFork = (philosopher + 1) % numPhilosophers;

        forks[leftFork].acquire();
        forks[rightFork].acquire();

        System.out.println("Philosopher " + philosopher + " start eating...");

        Thread.sleep(1000);

        forks[rightFork].release();
        forks[leftFork].release();

        System.out.println("Philosopher " + philosopher + " finish eating...");
        maxDiners.release();


    }

    public static void main(String[] args) throws InterruptedException {
        Test0513_zhexuejiajiucan_semaphore dp = new Test0513_zhexuejiajiucan_semaphore();

        for (int i = 0; i < numPhilosophers; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    dp.startEating(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
