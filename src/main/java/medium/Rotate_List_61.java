package medium;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Rotate_List_61 {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        int m = 0;
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
            m = i;
            if (fast == null) {
                fast = head;
                for (int j = 0; j < k % m; j++) {
                    fast = fast.next;
                }
                break;
            }
        }
        
        

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
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

        ListNode head = rotateRight2(node1, 2);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    public static ListNode rotateRight2(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;

        int len = length(head);
        k = k%len;

        for (int i = 0; i <= k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow = slow.next;

        fast = slow;

        while (fast.next != null) {
            fast = fast.next;
        }

        fast.next = head;

        return slow;
    }

    static int length(ListNode node) {
        int len = 0;

        while (node != null) {
            node = node.next;
            len++;
        }

        return len;
    }
}
