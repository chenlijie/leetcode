package medium;

/**
 * Created by chenlijie on 5/8/17.
 */
public class Sort_List_148 {

    public ListNode sortList(ListNode head) {

        if (head != null && head.next != null) {
            ListNode slow = head;
            ListNode fast = slow.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = slow.next;
            slow.next = null;
            slow = head;

            slow = sortList(slow);
            fast = sortList(fast);

            head = merge(slow, fast);
        }

        return head;
    }

    private ListNode merge(ListNode slow, ListNode fast) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;

        while (slow != null && fast != null) {
            if (slow.val < fast.val) {
                cursor.next = slow;
                slow = slow.next;
            } else {
                cursor.next = fast;
                fast = fast.next;
            }
            cursor = cursor.next;
        }

        while (slow != null) {
            cursor.next = slow;
            slow = slow.next;
            cursor = cursor.next;
        }

        while (fast != null) {
            cursor.next = fast;
            fast = fast.next;
            cursor = cursor.next;
        }

        return head.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        ListNode head = new Sort_List_148().sortList(node1);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }

    }

}
