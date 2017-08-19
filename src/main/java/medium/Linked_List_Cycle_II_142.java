package medium;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Linked_List_Cycle_II_142 {

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == fast ? slow : null;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(detectCycle(node1).val);
    }
}
