package medium;

/**
 * Created by chenlijie on 8/9/17.
 */
public class Reverse_Linked_List_II_92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slowPre = dummy;
        for (int i = 1; i < m; i++) {
            slowPre = slowPre.next;
        }
        ListNode slow = slowPre.next;
        ListNode slowForLate = slow;

        ListNode fast = slow.next;
        ListNode temp = null;

        for (int i = 0; i < n-m; i++) {
            temp = fast;
            fast = fast.next;
            temp.next = slow;
            slow = temp;
        }

        slowPre.next = slow;
        slowForLate.next = fast;

        return dummy.next;
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

        ListNode node = reverseBetween(node1, 3, 3);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
