package pingduoduo.deadlock;

/**
 * Created by wangchao on 2019/2/8.
 */
public class ProxyLeftLock extends Thread {



    private DeadLock lock;


    public ProxyLeftLock(DeadLock lock){
        this.lock=lock;
    }


    public void run(){
        try {
            lock.left();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
