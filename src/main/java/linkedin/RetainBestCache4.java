package linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RetainBestCache4 {

    static class Rank {
        int idx;
        long rank;
        int key;
        Rankable rankable;
    }

    private Rank[] ranks;
    private Map<Integer, Rank> cache;
    private int size = 0;
    private DataSource ds;

    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache4(DataSource ds, int entriesToRetain) {
        // Implementation here
        this.ds = ds;
        cache = new HashMap<>();
        ranks = new Rank[entriesToRetain];
    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,. visit 1point3acres.com for more.
     * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public Rankable get(int key) {
        // Implementation here. From 1point 3acres bbs
        if (cache.containsKey(key)) {
            return cache.get(key).rankable;
        }

        Rankable rankable = ds.get(key);
        Rank r = new Rank();
        r.key = key;
        r.rankable = rankable;
        r.rank = rankable.getRank();

        if (size == ranks.length) {
            Rank removal = ranks[0];
            cache.remove(removal.key);
            r.idx = 0;
            ranks[0] = r;
            siftDown(0, size);
        } else {
            r.idx = size;
            ranks[size++] = r;
            siftUp(size-1);
        }
        cache.put(key, r);

        return rankable;
    }

    private void siftUp(int i) {
        int p = (i-1)/2;
        if (p >= 0 && ranks[p].rank > ranks[i].rank) {
            swap(i, p);
            siftUp(p);
        }
    }

    private void siftDown(int i, int size) {
        int largest = i;

        if (2*i + 1 < size && ranks[largest].rank >  ranks[2*i + 1].rank) {
            largest = 2*i + 1;
        }

        if (2*i + 2 < size && ranks[largest].rank >  ranks[2*i + 2].rank) {
            largest = 2*i + 2;
        }

        if (largest != i) {
            swap(largest, i);
            siftDown(largest, size);
        }
    }

    private void swap(int i, int j) {
        ranks[i].idx = j;
        ranks[j].idx = i;

        Rank t = ranks[i];
        ranks[i] = ranks[j];
        ranks[j] = t;
    }

    public static void main(String[] args) {
        RetainBestCache4 cache = new RetainBestCache4(new DataSource(), 6);
        cache.get(10);
        cache.get(11);
        cache.get(7);
        cache.get(9);
        cache.get(15);
        cache.get(3);

        cache.get(50);
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
