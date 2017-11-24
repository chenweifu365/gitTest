package blogTest;

import java.util.*;

/**
 * Created by Administrator on 2017/9/6.
 */
public class LinkedSortedHashMap<K, V> extends HashMap<K, V> implements SortedMap<K, V> {
    LinkedList<Map.Entry<K, V>> linkedList = new LinkedList<Map.Entry<K, V>>();
    private final Comparator<? super K> comparator;

    public LinkedSortedHashMap() {
        comparator = null;
    }

    public LinkedSortedHashMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator comparator() {
        return null;
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        List<Map.Entry<K, V>> a = linkedList.subList(linkedList.indexOf(fromKey), linkedList.indexOf(toKey));
        LinkedSortedHashMap<K, V> map = new LinkedSortedHashMap<K, V>();
        for (Map.Entry entry : a) {
            map.put((K) entry.getKey(), (V) entry.getValue());
        }
        return map;
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return subMap(linkedList.getFirst().getKey(), toKey);
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return subMap(fromKey, linkedList.getLast().getKey());
    }

    @Override
    public K firstKey() {
        return linkedList.getFirst().getKey();
    }

    @Override
    public K lastKey() {
        return linkedList.getLast().getKey();
    }

    final int compare(Object k1, Object k2) {
        return comparator == null ? ((Comparable<? super K>) k1).compareTo((K) k2)
                : comparator.compare((K) k1, (K) k2);
    }

    @Override
    public V put(K key, V value) {
        V result = super.put(key, value);
        Map.Entry<K, V> mapEntry = null;
        for (Map.Entry<K, V> entry : this.entrySet()) {
            if (entry.getKey().equals(key)) {
                mapEntry = entry;
                break;
            }
        }
        if (linkedList.size() == 0) {
            linkedList.add(mapEntry);
        } else {
            for (Map.Entry<K, V> entry : linkedList) {
                K k1 = entry.getKey();
//                System.out.println("k1="+k1);
//                System.out.println("key="+key);
//                System.out.println("compare="+compare(k1, key));
                if (compare(key, k1) < 0) {
                    linkedList.add(linkedList.indexOf(entry), mapEntry);
                    break;
                }
//                System.out.println(linkedList);
            }
        }
        return result;
    }
}
