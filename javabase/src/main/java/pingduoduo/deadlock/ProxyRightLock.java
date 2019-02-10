package pingduoduo.deadlock;

/**
 * Created by wangchao on 2019/2/8.
 */
public class ProxyRightLock extends Thread {



    private DeadLock lock;


    public ProxyRightLock(DeadLock lock){
        this.lock=lock;
    }



    public void run(){
        try {
            lock.right();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
