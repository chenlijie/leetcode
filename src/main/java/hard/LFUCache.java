package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 8/3/17.
 */
public class LFUCache {

    static class DoubleLinkedNode {
        int key;
        int val;
        int cnt;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        public DoubleLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.cnt = 1;
        }
    }

    static class LinkedNode {
        int cnt;
        LinkedNode pre;
        LinkedNode next;
        DoubleLinkedNode head;
        DoubleLinkedNode tail;

        public LinkedNode(int cnt) {
            this.cnt = cnt;
            head = new DoubleLinkedNode(0, 0);
            tail = new DoubleLinkedNode(0, 0);
            head.cnt = 0;
            tail.cnt = 0;
            head.next = tail;
            tail.pre = head;
        }

        public void addFirstValNode(DoubleLinkedNode valNode) {
            head.next.pre = valNode;
            valNode.next = head.next;

            head.next = valNode;
            valNode.pre = head;
        }

        public DoubleLinkedNode removeLastValNode() {
            DoubleLinkedNode last = tail.pre;
            last.pre.next = tail;
            tail.pre = last.pre;
            return last;
        }

        public void removeValNode(DoubleLinkedNode valNode) {
            valNode.pre.next = valNode.next;
            valNode.next.pre = valNode.pre;
        }
    }

    int size;
    int capacity;
    LinkedNode head;
    LinkedNode tail;
    Map<Integer, LinkedNode> counts;
    Map<Integer, DoubleLinkedNode> values;

    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        counts = new HashMap<>();
        values = new HashMap<>();
        head = new LinkedNode(-1);
        tail = new LinkedNode(-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (values.containsKey(key)) {
            DoubleLinkedNode valNode = values.get(key);
            LinkedNode cntNode = counts.get(valNode.cnt);

            cntNode.removeValNode(valNode);

            int cnt = valNode.cnt + 1;
            LinkedNode nextCntNode = getOrCreateCntNode(cnt, cntNode);
            valNode.cnt = cnt;
            nextCntNode.addFirstValNode(valNode);

            if (cntNode.head.next == cntNode.tail) {
                removeCntNode(cntNode);
            }

            return valNode.val;
        }
        return -1;
    }

    void removeCntNode(LinkedNode cntNode) {
        cntNode.pre.next = cntNode.next;
        cntNode.next.pre = cntNode.pre;
        counts.remove(cntNode.cnt);
    }

    LinkedNode getOrCreateCntNode(int cnt, LinkedNode pre) {
        LinkedNode nextCntNode = counts.get(cnt);
        if (nextCntNode == null) {
            nextCntNode = new LinkedNode(cnt);

            nextCntNode.next = pre.next;
            pre.next.pre = nextCntNode;

            pre.next = nextCntNode;
            nextCntNode.pre = pre;
            counts.put(cnt, nextCntNode);
        }
        return nextCntNode;
    }

    public void put(int key, int value) {
        if (values.containsKey(key)) {
            get(key);
            return;
        }

        if (size == capacity) {
            LinkedNode cntNode = head.next;
            DoubleLinkedNode removedNode = cntNode.removeLastValNode();
            values.remove(removedNode.key);

            if (cntNode.head.next == cntNode.tail) {
                removeFirstCntNode();
            }
            size--;
        }

        DoubleLinkedNode valNode = new DoubleLinkedNode(key, value);
        values.put(key, valNode);
        LinkedNode cntOneNode = getOrCreateCntNode(1, head);
        cntOneNode.addFirstValNode(valNode);
        size++;
    }

    void removeFirstCntNode() {
        LinkedNode first = head.next;

        head.next = head.next.next;
        head.next.pre = head;

        counts.remove(first.cnt);
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(1);
        cache.put(2, 1);
        cache.get(2);
        cache.put(3, 2);
        cache.get(2);
        cache.get(3);
//        cache.put(2, 2);
//        cache.put(1, 1);
//        cache.get(2);       // returns 1
//        cache.get(1);       // returns 1
//        cache.get(2);       // returns 1
//        cache.put(3, 3);
//        cache.put(4, 4);    // evicts key 1
//
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(4));
    }
}
