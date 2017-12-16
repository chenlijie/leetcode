package linkedin;

import java.util.PriorityQueue;

/**
 * Created by chenlijie on 12/9/17.
 */
public class MaxStack2 {

    static class Node {
        int val;
        Node pre;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    PriorityQueue<Node> maxs;
    Node head;
    Node tail;

    public MaxStack2() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        maxs = new PriorityQueue<>((node1, node2)-> node2.val-node1.val);
    }

    int pop() {
        Node node = tail.pre;

        node.pre.next = tail;
        tail.pre = node.pre;

        maxs.remove(node);
        return node.val;
    }

    void push(int num) {
        Node node = new Node(num);
        tail.pre.next = node;
        node.pre = tail.pre;

        node.next = tail;
        tail.pre = node;

        maxs.add(node);
    }

    int peek() {
        return tail.pre.val;
    }

    int popMax() {
        Node node = maxs.poll();
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node.val;
    }

    int peekMax() {
        return maxs.peek().val;
    }

    public static void main(String[] args) {
        MaxStack2 stack = new MaxStack2();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.push(1);

        stack.print();
        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.pop());
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
