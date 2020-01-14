package microsoft.onsite;

import java.util.*;

public class MyHashTable<K, V> {

    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Entry[] table;
    private static int DEFAULT_CAPACITY = 1 << 4;
    private static float DEFAULT_LOAD_FACTOR = 0.75F;
    private int capacity;
    private float loadFactor;
    private int threshold;
    private int size = 0;

    public MyHashTable() {
        capacity = DEFAULT_CAPACITY;
        loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int)(DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
        table = new Entry[capacity];
    }

    public MyHashTable(int capacity, float loadFactor) {
        if (capacity < 0 || loadFactor < 0)
            throw new RuntimeException("Invalid parameter");

        this.capacity = capacity;
        this.loadFactor = loadFactor;
        threshold = (int)(capacity * loadFactor);
        table = new Entry[capacity];
    }

    public void put(K key, V value) {
        int h = (capacity - 1) & hash(key);

        if (table[h] == null) {
            table[h] = new Entry(key, value);
        } else {
            Entry<K, V> e = table[h];

            while (e.next != null)
                e = e.next;

            e.next = new Entry(key, value);
        }

        if (++size > threshold)
            reSize();
    }

    public V get(K key) {
        int h = (capacity - 1) & hash(key);

        if (table[h] != null) {
            Entry e = table[h];

            while (e != null) {
                if (e.getKey().hashCode() == key.hashCode() && key != null && key.equals(e.getKey())) {
                    return (V)e.getValue();
                }
                e = e.next;
            }
        }

        return null;
    }

    public boolean remove(K key) {
        if (key == null)
            throw new NullPointerException("key can not be null");

        int h = (capacity - 1) & hash(key);
        Entry<K, V> e = table[h];
        Entry<K, V> p = null;

        while (e != null) {
            if (e.getKey().hashCode() == key.hashCode() && key.equals(e.getKey())) {
                if (p == null) {
                    table[h] = e.next;
                } else {
                    p.next = e.next;
                }
                e = null;
                size--;
                return true;
            } else {
                p = e;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void reSize() {
        capacity = capacity << 1;
        threshold = (int)(capacity * loadFactor);

        Entry[] oldTab = table;
        table = new Entry[capacity];

        for (int i = 0; i < oldTab.length; i++) {
            if (oldTab[i] != null) {
                Entry<K, V> e = oldTab[i];

                while (e != null) {
                    put(e.getKey(), e.value);
                    e = e.next;
                }
            }
        }
    }

    private int hash(K key) {
        int h;
        return (h = key.hashCode()) ^ (h >>> 16);
    }


    public static void main(String[] args) throws Exception {

//        MyHashTable<Character, Integer> table = new MyHashTable<>(1 << 2, 0.75f);
//
//        for (int i = 1; i < 10; i++) {
//            table.put((char)('A' + i), 1);
//        }
//
//        System.out.println(table.size());

        MyHashTable<Fruit, Integer> table = new MyHashTable<>(1 << 4, 0.75f);

        Fruit apple = new Fruit("Apple", 1);
        Fruit banana = new Fruit("Banana", 2);
        table.put(apple, 1);
        table.put(banana, 2);

        System.out.println(table.get(apple));
        System.out.println(table.get(banana));

        table.remove(apple);
        System.out.println(table.get(apple));
        System.out.println(table.get(banana));

        table.remove(banana);
        System.out.println(table.get(apple));
        System.out.println(table.get(banana));

        System.out.println(table.size());
    }

    static class Fruit {
        String name;
        int size;

        public Fruit(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fruit)) return false;
            Fruit fruit = (Fruit) o;
            return Objects.equals(name, fruit.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash("Apple");
        }
    }

}
