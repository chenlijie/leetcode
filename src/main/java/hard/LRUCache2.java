package hard;

/**
 * Created by chenlijie on 8/3/17.
 */
public class LRUCache2 {

    private int capacity = 0;
    private int current = -1;
    private int[][] cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new int[2][capacity];
    }

    public int get(int key) {
        for (int i = 0; i <= current; i++) {
            if (cache[0][i] == key) {

                int tempKey = cache[0][i];
                int tempValue = cache[1][i];
                for (int j = i; j >= 1; j--) {
                    cache[0][j] = cache[0][j-1];
                    cache[1][j] = cache[1][j-1];
                }
                cache[0][0] = tempKey;
                cache[1][0] = tempValue;
                return tempValue;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int position = -1;
        for (int i = 0; i < current; i++) {

            if (cache[0][i] == key) {
                position = i;
                break;
            }
        }

        if (position == -1) {//not exist
            if (current < capacity-1 || current < 0) {
                current++;
            }

            for (int i = current; i >= 1; i--) {
                cache[0][i] = cache[0][i-1];
                cache[1][i] = cache[1][i-1];
            }
            cache[0][0] = key;
            cache[1][0] = value;
        } else {//exist
            for (int i = position; i >= 1; i--) {
                cache[0][i] = cache[0][i-1];
                cache[1][i] = cache[1][i-1];
            }
            cache[0][0] = key;
            cache[1][0] = value;
        }

    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
