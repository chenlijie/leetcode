package medium;

/**
 * Created by chenlijie on 8/9/17.
 */
public class Partition_List_86 {

    public static ListNode partition(ListNode head, int x) {

        ListNode less = new ListNode(0);
        ListNode lessP = less;
        ListNode greater = new ListNode(0);
        ListNode greaterP = greater;

        ListNode pointer = head;

        while (pointer != null) {
            if (pointer.val < x) {
                lessP.next = pointer;
                lessP = lessP.next;
            } else {
                greaterP.next = pointer;
                greaterP = greaterP.next;
            }
            pointer = pointer.next;
        }

        greaterP.next = null;
        lessP.next = greater.next;

        return less.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node = partition(node1, 4);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
