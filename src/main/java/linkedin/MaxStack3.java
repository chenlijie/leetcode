package linkedin;

import java.util.*;

/**
 * Created by chenlijie on 12/9/17.
 */
public class MaxStack3 {

    static class Node {
        int val;
        Node pre;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    TreeMap<Integer, Queue<Node>> maxs;
    Node head;
    Node tail;

    public MaxStack3() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        maxs = new TreeMap<>();
    }

    int pop() {
        Node node = tail.pre;

        node.pre.next = tail;
        tail.pre = node.pre;

        Queue<Node> nums = maxs.get(node.val);
        nums.poll();

        if (nums.isEmpty()) {
            maxs.remove(node.val);
        }

        return node.val;
    }

    void push(int num) {
        Node node = new Node(num);
        tail.pre.next = node;
        node.pre = tail.pre;

        node.next = tail;
        tail.pre = node;

        maxs.putIfAbsent(num, new LinkedList<>());
        maxs.get(num).add(node);
    }

    int peek() {
        return tail.pre.val;
    }

    int popMax() {
        Map.Entry<Integer, Queue<Node>> entry = maxs.lastEntry();
        int key = entry.getKey();
        Queue<Node> queue = entry.getValue();

        Node node = queue.poll();

        if (queue.isEmpty()) {
            maxs.remove(key);
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node.val;
    }

    int peekMax() {
        return maxs.lastEntry().getValue().peek().val;
    }

    public static void main(String[] args) {
        MaxStack3 stack = new MaxStack3();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(5);
//        stack.push(1);

        stack.print();
        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

        System.out.println(stack.popMax());
        stack.print();

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
