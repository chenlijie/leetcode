package linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RetainBestCache3 {

    private PriorityQueue<Rankable> queue;
    private Map<Integer, Rankable> cache;
    private Map<Rankable, Integer> cacheOp;
    private int size;
    private DataSource ds;

    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache3(DataSource ds, int entriesToRetain) {
        // Implementation here
        this.ds = ds;
        queue = new PriorityQueue<>((o1,o2) -> (int)(o1.getRank()-o2.getRank()));
        cache = new HashMap<>();
        cacheOp = new HashMap<>();
        size = entriesToRetain;
    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,. visit 1point3acres.com for more.
     * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public Rankable get(int key) {
        // Implementation here. From 1point 3acres bbs
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (cache.size() == size) {
            Rankable t = queue.poll();
            int k = cacheOp.get(t);
            cache.remove(k);
            cacheOp.remove(t);
        }

        Rankable obj = ds.get(key);
        queue.offer(obj);
        cache.put(key, obj);
        cacheOp.put(obj, key);

        return obj;
    }

    public static void main(String[] args) {
        RetainBestCache3 cache = new RetainBestCache3(new DataSource(), 2);
        cache.get(10);
        cache.get(2);
        cache.get(3);
        cache.get(4);
    }


    static class Rankable {
        int val;
        int rank;

        public Rankable(int val, int rank) {
            this.val = val;
            this.rank = rank;
        }

        long getRank() {
            return rank;
        }
    }

    static class DataSource {
        Rankable get (int key) {
            int i = key;

            return new Rankable(i, i/5);
        }
    }
}
