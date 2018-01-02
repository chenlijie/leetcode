package facebook;

import medium.ListNode;

/**
 * Created by chenlijie on 12/17/17.
 */
public class PrintLinkedListInReverse {

    void recursivePrint(ListNode node) {
        if (node != null) {
            recursivePrint(node.next);
            System.out.print(node.val + " ");
        }
    }

    void mergePrint(ListNode node) {
        ListNode end = node;

        while (end != null && end.next != null) {
            end = end.next;
        }

        mergePrint(node, end);
    }

    void mergePrint(ListNode node, ListNode end) {
        if (node == null)
            return;

        if (node == end) {
            System.out.print(node.val + " ");
        } else {
            ListNode slow = node;
            ListNode fast = node;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            mergePrint(slow.next, end);

            mergePrint(node, slow);
        }
    }
}
