import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


/*
 * @lc app=leetcode.cn id=1226 lang=java
 *
 * [1226] 哲学家进餐
 */

// @lc code=start
class DiningPhilosophers {

    // 只有4人能开展竞争，保证一人能就餐。
    // private final ReentrantLock[] forkLock = {
    //     new ReentrantLock(),
    //     new ReentrantLock(),
    //     new ReentrantLock(),
    //     new ReentrantLock(),
    //     new ReentrantLock()
    // };

    // private Semaphore eatLimit = new Semaphore(4);

    // public DiningPhilosophers() {
        
    // }

    // // call the run() method of any runnable to execute its code
    // public void wantsToEat(int philosopher,
    //                        Runnable pickLeftFork,
    //                        Runnable pickRightFork,
    //                        Runnable eat,
    //                        Runnable putLeftFork,
    //                        Runnable putRightFork) throws InterruptedException {
    //     int leftFork = (philosopher + 1) % 5;
    //     int rightFork = philosopher;
        
    //     eatLimit.acquire();
    //     forkLock[leftFork].lock();
    //     forkLock[rightFork].lock();
        

    //     pickLeftFork.run();
    //     pickRightFork.run();

    //     eat.run();

    //     putLeftFork.run();
    //     putRightFork.run();

    //     forkLock[leftFork].unlock();
    //     forkLock[rightFork].unlock();

    //     eatLimit.release();

    // }




    // 只设置一把锁，每次只能有一个人在进餐，拿到锁才能拿叉子
    private final ReentrantLock eatLimit = new ReentrantLock();

    public DiningPhilosophers() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        eatLimit.lock();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        eatLimit.unlock();
        

    }
}
// @lc code=end

