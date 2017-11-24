package blogTest;


/**
 * Created by Administrator on 2017/8/31.
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new LockRunnable()).start();
        LockRunnable.firstSay();
    }
}
