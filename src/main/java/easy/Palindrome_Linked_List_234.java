package easy;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Palindrome_Linked_List_234 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = revertList(slow.next);
        slow = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode revertList(ListNode head) {
        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return head;
    }

    public static void main(String[] args) {
        Palindrome_Linked_List_234.ListNode node1 = new Palindrome_Linked_List_234.ListNode(1);
        Palindrome_Linked_List_234.ListNode node2 = new Palindrome_Linked_List_234.ListNode(2);
        Palindrome_Linked_List_234.ListNode node3 = new Palindrome_Linked_List_234.ListNode(3);
        Palindrome_Linked_List_234.ListNode node4 = new Palindrome_Linked_List_234.ListNode(2);
        Palindrome_Linked_List_234.ListNode node5 = new Palindrome_Linked_List_234.ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new Palindrome_Linked_List_234().isPalindrome(node4));
    }
}
