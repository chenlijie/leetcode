package linkedin;

import java.util.*;

/**
 * Created by chenlijie on 12/9/17.
 */
public class MaxStack {

    static class Node {
        int val;
        Node pre;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    List<Node> maxs;
    Map<Node, Integer> locs;
    int size;
    Node head;
    Node tail;

    public MaxStack() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        maxs = new ArrayList<>();
        locs = new HashMap<>();
        size = 0;
    }

    int pop() {
        Node node = tail.pre;

        node.pre.next = tail;
        tail.pre = node.pre;

        int i = locs.get(node);
        int last = size-1;

        swap(i, last);
        locs.remove(node);
        size--;
        siftDown(i);

        return node.val;
    }

    void siftDown(int i) {
        int largest = i;
        if (2*i + 1 < size && maxs.get(largest).val < maxs.get(2*i + 1).val) {
            largest = 2*i + 1;
        }
        if (2*i + 2 < size && maxs.get(largest).val < maxs.get(2*i + 2).val) {
            largest = 2*i + 2;
        }
        if (largest != i) {
            swap(largest, i);
            siftDown(largest);
        }
    }

    void swap(int i, int j) {
        Node nodeI = maxs.get(i);
        Node nodeJ = maxs.get(j);
        maxs.set(i, nodeJ);
        maxs.set(j, nodeI);
        locs.put(nodeI, j);
        locs.put(nodeJ, i);
    }

    void push(int num) {
        Node node = new Node(num);
        tail.pre.next = node;
        node.pre = tail.pre;

        node.next = tail;
        tail.pre = node;

        maxs.add(node);
        locs.put(node, size);
        siftUp(size);
        size++;
    }

    void siftUp(int i) {
        int p = getParentIdx(i);
        Node cur = maxs.get(i);
        Node par = maxs.get(p);

        if (cur.val > par.val) {
            maxs.set(i, par);
            maxs.set(p, cur);
            locs.put(cur, p);
            locs.put(par, i);

            if (p > 0) {
                siftUp(p);
            }
        }
    }

    int getParentIdx(int i) {
        return (i-1)/2;
    }

    int peek() {
        return tail.pre.val;
    }

    int popMax() {
        Node maxNode = maxs.get(0);

        maxNode.pre.next = maxNode.next;
        maxNode.next.pre = maxNode.pre;

        int val = maxNode.val;

        size--;
        swap(0, size);
        maxs.remove(size);
        locs.remove(maxNode);

        siftDown(0);

        return val;
    }

    int peekMax() {
        return maxs.get(0).val;
    }


    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(3);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(1);

        stack.print();
        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();


        Map<Node, Integer> tree = new TreeMap<>((n1, n2)->n2.val-n1.val);

        tree.put(new Node(2), 1);
        tree.put(new Node(5), 3);
        tree.put(new Node(5), 3);
        tree.put(new Node(4), 5);
        tree.put(new Node(1), 4);
        tree.put(new Node(3), 2);

        for (Node k : tree.keySet()) {
            System.out.print(k.val + ", ");
        }
        System.out.println();

        for (Node k : tree.keySet()) {
            System.out.print(tree.get(k) + ", ");
        }

        Comparator<Node> tComparator = (n1, n2) -> n1.val-n2.val == 0 ? n2.val-n1.val : n1.val - n2.val;
        Arrays.sort(new Node[]{}, tComparator);
    }

    void print() {
        Node cur = head.next;
        while (cur != tail) {
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }
        System.out.println();
    }
}
