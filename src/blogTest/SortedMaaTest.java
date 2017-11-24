package blogTest;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/9/6.
 */
public class SortedMaaTest {
    public static void main(String[] args) {
        LinkedSortedHashMap<String, Integer> map = new LinkedSortedHashMap<String, Integer>();
        TreeMap<String, Integer> treeMapmap = new TreeMap<String, Integer>();
        int forcount = 30000;

        long timestamp = System.currentTimeMillis();
        for (int i = 0; i < forcount; i++) {
            int s = (int) (Math.random() * forcount);
            map.put(s + "", s);
        }
        long timestamp2 = System.currentTimeMillis();
        System.out.println("myTime:" + (timestamp2 - timestamp));

        for (int i = 0; i < forcount; i++) {
            int s = (int) (Math.random() * forcount);
            treeMapmap.put(s + "", s);
        }
        long timestamp3 = System.currentTimeMillis();
        System.out.println("treeTime:" + (timestamp3 - timestamp2));

        for (Map.Entry entry : map.linkedList) {
            entry.getKey();
        }
        long timestamp4 = System.currentTimeMillis();
        System.out.println("myGetTime:" + (timestamp4 - timestamp3));

        for (Map.Entry<String, Integer> entry : treeMapmap.entrySet()) {
//            System.out.print(entry.getKey()+" ");
            entry.getKey();
        }
        long timestamp5 = System.currentTimeMillis();
        System.out.println("TreeGetTime:" + (timestamp5 - timestamp4));
    }
}
