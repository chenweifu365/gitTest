package tianchai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/11/13.
 */
public class QQ360Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String userName = "Ahalei";
        List<String> msgList = new ArrayList<String>();
        Set<QQObject> qqObjectSet = new TreeSet<QQObject>();
        Scanner scanner = new Scanner(System.in);
        String str = null;
        while ((str = scanner.nextLine()) != null && str.length() > 0) {
            msgList.add(str);
        }
        scanner.close();
        userName = msgList.get(0).trim();
        msgList.remove(0);
        for (String msg : msgList) {
            String[] qqObjectMsgs = msg.split(" ");
            if (qqObjectMsgs == null || qqObjectMsgs.length < 4) {
                throw new RuntimeException("msg cannot parse!");
            }
            String msgTimeString = qqObjectMsgs[0] + " " + qqObjectMsgs[1];
            String msgUserName = qqObjectMsgs[2];
            String msgMessage = msg.substring(msg.indexOf(" ", 20) + 1);
            try {
                Date sayTime = sdf.parse(msgTimeString);
                QQObject q = new QQObject();
                q.sayTime = sayTime;
                q.message = msgMessage;
                q.userName = msgUserName;
                qqObjectSet.add(q);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        for (QQObject q : qqObjectSet) {
            if (userName.equals(q.userName)) {
                System.out.println(q.message);
            }
        }
    }

    static class QQObject implements Comparable {
        Date sayTime;
        String userName;
        String message;

        @Override
        public int compareTo(Object o) {
            QQObject o2 = (QQObject) o;
            return (int) (o2.sayTime.getTime() - this.sayTime.getTime());
        }
    }
}
