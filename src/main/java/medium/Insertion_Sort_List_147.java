package medium;

/**
 * Created by chenlijie on 8/9/17.
 */
public class Insertion_Sort_List_147 {

    public static ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode(0);

        while (head != null) {

            ListNode node = head;
            head = head.next;

            ListNode previous = dummyHead;
            ListNode current = previous.next;


            while (current != null && current.val < node.val) {
                previous = current;
                current = current.next;
            }

            previous.next = node;
            node.next = current;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = null;//new ListNode(2);
//        ListNode node2 = new ListNode(5);
//        node1.next = node2;
//        ListNode node3 = new ListNode(3);
//        node2.next = node3;
//
//        ListNode node4 = new ListNode(1);
//        node3.next = node4;
//
//        ListNode node5 = new ListNode(4);
//        node4.next = node5;

        ListNode node = insertionSortList(node1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
