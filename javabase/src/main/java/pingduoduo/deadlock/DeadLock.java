package pingduoduo.deadlock;

/**
 * Created by wangchao on 2019/2/8.
 */
public class DeadLock {



    private final Object left=new Object();

    private final Object right=new Object();


    public void left() throws Exception{
        synchronized (left){
            Thread.sleep(2000);
            synchronized (right){
                System.out.print("左边");
            }
        }
    }


    public void right() throws Exception{
        synchronized (right){
            Thread.sleep(2000);
            synchronized (left){
                System.out.print("左边");
            }
        }
    }
}
