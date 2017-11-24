package blogTest;

/**
 * Created by Administrator on 2017/8/31.
 */
public class LockRunnable implements Runnable {

    public static void main(String[] args) {
        new Thread(new LockRunnable()).start();
        LockRunnable.firstSay();
    }

    public void run() {
        secondSay();
    }

    public static synchronized void firstSay() {
        try {
            say("first1111");
            Thread.sleep(1000);
            LockRunnable.class.wait();
            say("first2222");
            Thread.sleep(1000);
            say("first3333");
        } catch (Exception e) {

        }
    }

    public static synchronized void secondSay() {
        try {
            say("second1111");
            Thread.sleep(300);
            //notifyAll后会通知线程结束wait，进入准备竞争锁的状态。
            LockRunnable.class.notifyAll();
            say("second2222");
            Thread.sleep(3000);
            say("second3333");
        } catch (Exception e) {

        }
    }

    public static void say(String s) {
        System.out.println(s);
    }

}
