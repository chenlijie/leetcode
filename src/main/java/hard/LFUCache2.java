package hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by chenlijie on 8/4/17.
 */
public class LFUCache2 {


    int capacity = 0;
    int min = -1;
    // key : cnt
    Map<Integer, Integer> cnts = new HashMap<>();
    // key : val
    Map<Integer, Integer> vals = new HashMap<>();
    // cnt : key set
    Map<Integer, LinkedHashSet<Integer>> lists = new HashMap<>();


    public LFUCache2(int capacity) {
        this.capacity = capacity;
        lists.putIfAbsent(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (vals.containsKey(key)) {
            int cnt = cnts.get(key);
            LinkedHashSet<Integer> keys = lists.get(cnt);
            keys.remove(key);
            if (min == cnt && keys.isEmpty()) {
                min++;
            }
            lists.putIfAbsent(cnt + 1, new LinkedHashSet<>());
            lists.get(cnt + 1).add(key);
            cnts.put(key, cnt + 1);
            return vals.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            LinkedHashSet<Integer> keys = lists.get(min);
            int evict = keys.iterator().next();
            keys.remove(evict);
            vals.remove(evict);
        }
        lists.get(1).add(key);
        vals.put(key, value);
        cnts.put(key, 1);
        min = 1;
    }


    public static void main(String[] args) {
        LFUCache2 cache = new LFUCache2( 3 /* capacity */ );

        cache.put(2, 2);
        cache.put(1, 1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));       // returns 1
        System.out.println(cache.get(2));
        cache.put(3, 3);    // evicts key 2
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(3));       // returns 3.
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(4));       // returns 4
    }
}
