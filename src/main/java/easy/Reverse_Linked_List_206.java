package easy;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Reverse_Linked_List_206 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode cur1;
        ListNode cur2 = head.next;
        head.next = null;

        while (cur2 != null) {
            cur1 = cur2;
            cur2 = cur2.next;

            cur1.next = head;
            head = cur1;
        }

        return head;
    }

    public static void main(String[] args) {
        Reverse_Linked_List_206.ListNode node1 = new Reverse_Linked_List_206.ListNode(1);
        Reverse_Linked_List_206.ListNode node2 = new Reverse_Linked_List_206.ListNode(2);
        Reverse_Linked_List_206.ListNode node3 = new Reverse_Linked_List_206.ListNode(3);
        Reverse_Linked_List_206.ListNode node4 = new Reverse_Linked_List_206.ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Reverse_Linked_List_206.ListNode node = new Reverse_Linked_List_206().reverseList(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
