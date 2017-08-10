package medium;

/**
 * Created by chenlijie on 8/9/17.
 */
public class Remove_Duplicates_from_Sorted_List_II_82 {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previous = dummy;

        ListNode current = head;
        ListNode next = null;
        if (current != null) {
            next = current.next;
        }

        while (current != null && next != null) {

            if (current.val != next.val) {
                previous = current;
                current = current.next;
                next = next.next;
                continue;
            }

            while (next != null && current.val == next.val) {
                next = next.next;
            }

            previous.next = next;
            current = next;

            if (next != null) {
                next = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node = deleteDuplicates(node1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
