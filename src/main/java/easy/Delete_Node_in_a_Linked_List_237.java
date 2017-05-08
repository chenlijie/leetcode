package easy;

import medium.Odd_Even_Linked_List_328;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Delete_Node_in_a_Linked_List_237 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
