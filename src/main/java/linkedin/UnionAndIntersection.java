package linkedin;


import medium.ListNode;

import java.util.*;

/**
 * Created by chenlijie on 12/11/17.
 */
public class UnionAndIntersection {
//http://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    //Union and Intersection of two Linked Lists
    //union and intersection
    static ListNode[] unionAndIntersection(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return new ListNode[] {head2, null};
        }

        if (head2 == null) {
            return new ListNode[] {head1, null};
        }

        Set<Integer> set = new HashSet<>();

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while (true) {
            set.add(cur1.val);
            if (cur1.next == null) {
                break;
            }
            cur1 = cur1.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (cur2 != null) {
            if (set.contains(cur2.val)) {
                cur.next = cur2;
                cur = cur.next;
            } else {
                cur1.next = cur2;
                cur1 = cur1.next;
            }
            cur2 = cur2.next;
        }
        cur1.next = null;
        cur.next = null;

        return new ListNode[] {head1, dummy.next};
    }

    ListNode getIntersection(ListNode h1, ListNode h2) {
        Map<Integer, Integer> cnts = new HashMap<>();

        while (h1 != null) {
            cnts.put(h1.val, cnts.getOrDefault(h1.val, 0) + 1);
            h1 = h1.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (h2 != null) {
            if (cnts.getOrDefault(h2.val, 0) > 0) {
                append(cur, h2.val);
                cur = cur.next;
                cnts.put(h2.val, cnts.get(h2.val) - 1);
            }
            h2 = h2.next;
        }

        return dummy.next;
    }

    ListNode getUnion(ListNode h1, ListNode h2) {
        Map<Integer, Integer> cnts = new HashMap<>();

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (h1 != null) {
            cnts.put(h1.val, cnts.getOrDefault(h1.val, 0) + 1);
            append(cur, h1.val);
            cur = cur.next;
            h1 = h1.next;
        }

        while (h2 != null) {
            if (cnts.getOrDefault(h2.val, 0) > 0) {
                cnts.put(h2.val, cnts.get(h2.val) - 1);
            } else {
                append(cur, h2.val);
                cur = cur.next;
            }
            h2 = h2.next;
        }

        return dummy.next;
    }

    List<Integer> getListIntersection(List<Integer> l1, List<Integer> l2) {

        return null;
    }


    void append(ListNode cur, int val) {
        ListNode node = new ListNode(val);
        cur.next = node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(3);

        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(1);
        ListNode node25 = new ListNode(3);
        ListNode node27 = new ListNode(1);

        node1.next = node3;
        node3.next = node4;
        node4.next = node6;

        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node27;

//        ListNode[] nodes = unionAndIntersection(node1, node22);
//        print(nodes[0]);
//        System.out.println();
//        print(nodes[1]);

        UnionAndIntersection inter = new UnionAndIntersection();
        ListNode in = inter.getUnion(node1, node22);
        print(in);

    }

    static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }
}
