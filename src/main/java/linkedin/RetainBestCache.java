package linkedin;

import java.util.*;

public class RetainBestCache<K, T extends Rankable> {

    private Map<K, T> cache;
    private Map<Long, Set<K>> rankingOfObject;
    private DataSource<K, T> dataSource;
    private int maxSizeOfCache;

    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache(DataSource<K,T> ds, int entriesToRetain) {
        // Implementation here
        cache = new HashMap<>();
        rankingOfObject = new TreeMap<>();
        dataSource = ds;
        maxSizeOfCache = entriesToRetain;
    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,. visit 1point3acres.com for more.
     * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public T get(K key) {
        // Implementation here. From 1point 3acres bbs
        if(cache.containsKey(key)) { 
            return cache.get(key);
        }
        return fetchDataFromDs(key);
    }

    private T fetchDataFromDs(K key) {
        if(cache.size() >= maxSizeOfCache) {
            evictElement();
        }
        T object = dataSource.get(key);
        cache.put(key, object);
        long rankOfObject = object.getRank();
        if(!rankingOfObject.containsKey(rankOfObject)) {
            rankingOfObject.put(rankOfObject, new HashSet<>());
        }
        rankingOfObject.get(rankOfObject).add(key);
        return object;
    }

    private void evictElement() {
        Map.Entry<Long, Set<K>> entry = null;//rankingOfObject.topEntry();
        K key = entry.getValue().iterator().next();
        entry.getValue().remove(key);
        cache.remove(key);
        if(entry.getValue().size() == 0) {
            rankingOfObject.remove(entry.getKey());
        }
    }

}

// What if rank is defined as number of reads of element in cache?
// LRU
// Let's assume that rank can change dynamicly. It is not immutable, but it is not LRU. We do not know how it is changed. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴

/*. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
* For reference, here are the Rankable and DataSource interfaces.
* You do not need to implement them, and should not make assumptions
* about their implementations.-google 1point3acres
*/

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
