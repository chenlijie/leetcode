package medium;

/**
 * Created by chenlijie on 10/23/17.
 */
public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

    public static TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    static TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        if (head.next == tail) {
            return new TreeNode(head.val);
        }
        ListNode first = head;
        ListNode second = head;
        while (second != tail && second.next != tail) {
            first = first.next;
            second = second.next.next;
        }
        TreeNode node = new TreeNode(first.val);
        node.left = sortedListToBST(head, first);
        node.right = sortedListToBST(first.next, tail);
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        TreeNode node = sortedListToBST(node1);
        System.out.println(node);
    }
}
