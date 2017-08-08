package medium;

import java.util.List;

/**
 * Created by chenlijie on 8/7/17.
 */
public class Swap_Nodes_in_Pairs_24 {

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode tail = new ListNode(0);
        tail.next = head;

        ListNode f = head;
        ListNode s = f.next;

        ListNode newHead = s;

        while (f != null && s != null) {
            f.next = s.next;
            s.next = f;
            tail.next = s;

            tail = f;
            f = tail.next;

            if (f != null) {
                s = f.next;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode node = swapPairs(n1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
