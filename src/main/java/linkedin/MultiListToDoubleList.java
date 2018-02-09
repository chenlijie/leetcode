package linkedin;

import hard.LFUCache;
import medium.TreeNode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MultiListToDoubleList {
    static class MultiListNode {
        int val;
        MultiListNode pre;
        MultiListNode next;
        MultiListNode up;
        MultiListNode down;
    }

    public static void convert(MultiListNode head) {
        if (head == null) {
            return;
        }

        MultiListNode tail = head;
        while (tail.next != null) {
                tail = tail.next;
        }

        MultiListNode cur = head;
        while (cur != null) {
            if (cur.up != null) {
                tail.next = cur.up;
                cur.up.pre = tail;
                while (tail.next != null) {
                        tail = tail.next;
                }
                cur.up = null;
            }

            if (cur.down != null) {
                tail.next = cur.down;
                cur.down.pre = tail;
                while (tail.next != null) {
                    tail = tail.next;
                }
                cur.down = null;
            }
            cur = cur.next;
        }
    }



    public static void main(String[] args) {
        PriorityQueue<TreeNode> q = new PriorityQueue<>((t1,t2)->t2.val-t1.val);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(7);
//        System.out.println(n1);
//        System.out.println(n2);

        q.offer(n1);
        q.offer(n2);
        q.offer(n3);

//        System.out.println(q.peek());
//        System.out.println(q.peek().val);
//
//        n1.val = 100;
//        System.out.println(q.peek());
//        System.out.println(q.peek().val);
//
//        System.out.println("-----");
//        System.out.println(q.poll().val);
//        System.out.println(q.poll().val);
//        System.out.println(q.poll().val);
//
//
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(4, 4);
        map.put(2, 2);
        map.put(1, 1);
        map.put(3, 3);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
