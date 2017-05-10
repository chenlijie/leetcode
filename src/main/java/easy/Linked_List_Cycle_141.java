package easy;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Linked_List_Cycle_141 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null) {
            if (slow.next == fast.next.next) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
