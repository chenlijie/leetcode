package medium;

import easy.Reverse_Linked_List_206;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Odd_Even_Linked_List_328 {


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even;

        while (odd.next != null) {
            even = odd.next;

            odd.next = odd.next.next;

            if (even.next != null)
                even.next = even.next.next;
            else
                even.next = null;

            odd = odd.next;
        }


        return null;

    }
}
