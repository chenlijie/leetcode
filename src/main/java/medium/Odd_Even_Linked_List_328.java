package medium;

import easy.Reverse_Linked_List_206;

import java.util.List;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Odd_Even_Linked_List_328 {


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 1  2  3  4  5  6  7
     *   e  o
     *
     *
     */

    public static ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head;
            ListNode evenHead = odd.next;
            ListNode even = evenHead;

            while (even != null) {
                odd.next = even.next;
                if (odd.next != null) {
                    odd = odd.next;
                }

                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node1 = oddEvenList(head);
        while (node1 != null) {
            System.out.print(node1.val + ", ");
            node1 = node1.next;
        }
    }
}
