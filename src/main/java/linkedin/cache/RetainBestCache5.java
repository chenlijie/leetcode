package linkedin.cache;


import java.util.HashMap;
import java.util.Map;

public class RetainBestCache5<K, T extends Rankable> {

    static class Rank<K, T extends Rankable> {
        int idx;
        long rank;
        K key;
        T rankable;
    }

    private Rank[] ranks;
    private Map<K, Rank> cache;
    private int size = 0;
    private DataSource ds;

    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache5(DataSource<K,T> ds, int entriesToRetain) {
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
    public T get(K key) {
        // Implementation here. From 1point 3acres bbs
        if (cache.containsKey(key)) {
            return (T)cache.get(key).rankable;
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

        return (T)rankable;
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
//        RetainBestCache5 cache = new RetainBestCache5(new DataSource(), 6);
//        cache.get(10);
//        cache.get(11);
//        cache.get(7);
//        cache.get(9);
//        cache.get(15);
//        cache.get(3);
//
//        cache.get(50);
    }
}

interface Rankable {
    /**
     * Returns the Rank of this object, using some algorithm and potentially
     * the internal state of the Rankable.
     */
    long getRank();
}

interface DataSource<K, T extends Rankable> {
    T get (K key);
}