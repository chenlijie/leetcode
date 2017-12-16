package medium;

/**
 * Created by chenlijie on 5/8/17.
 */
public class Sort_List_148 {

    public ListNode sortList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = slow.next;
            slow.next = null;

            ListNode leftPart = sortList(head);
            ListNode rightPart = sortList(fast);

            return merge(leftPart, rightPart);
        }

        return head;
    }

    private ListNode merge(ListNode leftPart, ListNode rightPart) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (leftPart != null && rightPart != null) {
            if (leftPart.val < rightPart.val) {
                cur.next = leftPart;
                leftPart = leftPart.next;
            } else {
                cur.next = rightPart;
                rightPart = rightPart.next;
            }
            cur = cur.next;
        }

        while (rightPart != null) {
            cur.next = rightPart;
            rightPart = rightPart.next;
            cur = cur.next;
        }

        while (leftPart != null) {
            cur.next = leftPart;
            leftPart = leftPart.next;
            cur = cur.next;
        }

        return dummy.next;
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
