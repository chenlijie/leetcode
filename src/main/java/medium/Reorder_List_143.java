package medium;

/**
 * Created by chenlijie on 8/10/17.
 */
public class Reorder_List_143 {

    public static void reorderList(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int step = 0;

        while (fast != null && fast.next != null) {
            step++;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            step--;
        }
        fast = slow.next;
        slow.next = null;

        slow = head;
        while (step > 0) {

            ListNode f = fast;
            for (int i = 1; i < step; i++) {
                f = f.next;
            }

            f.next = slow.next;
            slow.next = f;
            slow = f.next;
            step--;
        }

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;

        reorderList(node1);
        ListNode node = node1;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}
