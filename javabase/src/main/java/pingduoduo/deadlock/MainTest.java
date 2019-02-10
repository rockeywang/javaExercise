package pingduoduo.deadlock;

/**
 * 模拟线程死锁
 * 当一个线程永远地持有一个锁，并且其他线程都尝试去获得这个锁时，那么它们将永远被阻塞，这个我们都知道。
 * 如果线程A持有锁L并且想获得锁M，线程B持有锁M并且想获得锁L，那么这两个线程将永远等待下去，这种情况就是最简单的死锁形式。
 * Created by wangchao on 2019/2/8.
 */
public class MainTest {


    public static void main(String[] args) {
        DeadLock lock = new DeadLock();
        new ProxyLeftLock(lock).start();
        new ProxyRightLock(lock).start();
    }
}
