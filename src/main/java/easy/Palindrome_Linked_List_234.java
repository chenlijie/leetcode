package easy;

import java.util.TreeMap;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Palindrome_Linked_List_234 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 1 2 3
     *   S F
     *
     * 1 2
     *   S F
     *
     * 1 2 3 4 5 6
     *       S     F
     */

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        //find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second part
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while (slow != null && fast != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    ListNode reverseList(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Palindrome_Linked_List_234.ListNode node1 = new Palindrome_Linked_List_234.ListNode(1);
        Palindrome_Linked_List_234.ListNode node2 = new Palindrome_Linked_List_234.ListNode(2);
        Palindrome_Linked_List_234.ListNode node3 = new Palindrome_Linked_List_234.ListNode(3);
        Palindrome_Linked_List_234.ListNode node4 = new Palindrome_Linked_List_234.ListNode(2);
        Palindrome_Linked_List_234.ListNode node5 = new Palindrome_Linked_List_234.ListNode(1);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        System.out.println(new Palindrome_Linked_List_234().isPalindrome(node1));

    }
}
