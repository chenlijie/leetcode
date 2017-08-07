package hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by chenlijie on 8/4/17.
 */
public class LFUCache {


    int capacity = 0;
    int count = 0;
    Map<Integer, CountNode> countMap = new HashMap<>();
    Map<Integer, ValueNode> valueMap = new HashMap<>();

    CountNode countHead = new CountNode();
    CountNode countTail = new CountNode();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        countHead.next = countTail;
        countTail.pre = countHead;
    }

    public int get(int key) {
        if (valueMap.get(key) == null) {
            return -1;
        } else {
            ValueNode valueNode = valueMap.get(key);
            CountNode countNode = valueNode.countNode;
            CountNode preCountNode = countNode.pre;
            int count = countNode.count;

            removeValueNodeFromLink(valueNode);

            if (countMap.get(count+1) == null) {
                addValueNodeToCountNode(valueNode, createCountNode(count+1, preCountNode, countNode));
            } else {
                addValueNodeToCountNode(valueNode, countMap.get(count+1));
            }

            removeCountNode(countNode);

            return valueNode.value;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (valueMap.get(key) == null) {

            if (count == capacity) {
                removeValueNode();
            }

            ValueNode valueNode = createValueNode(key, value);

            if (countMap.get(1) == null) {
                createCountNode(1, countTail.pre, countTail);
            }

            addValueNodeToCountNode(valueNode, countMap.get(1));

        } else {
            ValueNode valueNode = valueMap.get(key);
            CountNode countNode = valueNode.countNode;
            CountNode preCountNode = countNode.pre;
            int count = countNode.count;

            valueNode.value = value;

            removeValueNodeFromLink(valueNode);

            if (countMap.get(count + 1) == null) {
                CountNode newCountNode = createCountNode(count + 1, preCountNode, countNode);
                addValueNodeToCountNode(valueNode, newCountNode);

            } else {
                CountNode existCountNode = countMap.get(count + 1);
                addValueNodeToCountNode(valueNode, existCountNode);
            }

            removeCountNode(countNode);
        }
    }

    void removeValueNode() {
        valueMap.remove(countTail.pre.valueTail.pre.key);
        removeValueNodeFromLink(countTail.pre.valueTail.pre);
        removeCountNode(countTail.pre);
        count--;
    }

    ValueNode createValueNode(int key, int value) {
        ValueNode valueNode = new ValueNode();
        valueNode.key = key;
        valueNode.value = value;
        valueMap.put(key, valueNode);
        count++;
        return valueNode;
    }

    void removeCountNode(CountNode countNode) {

        if (countNode.valueHead.next == countNode.valueTail) {
            countNode.pre.next = countNode.next;
            countNode.next.pre = countNode.pre;

            countMap.remove(countNode.count);
        }
    }

    CountNode createCountNode(int count, CountNode preCountNode, CountNode countNode) {
        CountNode newCountNode = new CountNode();
        newCountNode.count = count;
        countMap.put(count, newCountNode);

        preCountNode.next = newCountNode;
        newCountNode.next = countNode;

        countNode.pre = newCountNode;
        newCountNode.pre = preCountNode;

        return  newCountNode;
    }

    void addValueNodeToCountNode(ValueNode valueNode, CountNode countNode) {
        ValueNode head = countNode.valueHead;
        ValueNode next = countNode.valueHead.next;

        head.next = valueNode;
        valueNode.next = next;

        next.pre = valueNode;
        valueNode.pre = head;

        valueNode.countNode = countNode;
    }

    void removeValueNodeFromLink(ValueNode valueNode) {
        valueNode.pre.next = valueNode.next;
        valueNode.next.pre = valueNode.pre;
    }

    static class ValueNode {
        int key;
        int value;
        CountNode countNode;

        ValueNode pre;
        ValueNode next;
    }

    static class CountNode {
        int count;

        CountNode pre;
        CountNode next;

        ValueNode valueHead = new ValueNode();
        ValueNode valueTail = new ValueNode();

        public CountNode() {
            valueHead.next = valueTail;
        }
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 0 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

        LinkedHashSet<String> hs = new LinkedHashSet();

        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");

        for (String s : hs) {
            System.out.println(s);
        }
        System.out.println(hs);
    }
}
