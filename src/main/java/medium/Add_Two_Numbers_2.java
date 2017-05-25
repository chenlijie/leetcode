package medium;

import java.util.List;

/**
 * Created by chenlijie on 5/18/17.
 */
public class Add_Two_Numbers_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode head = head1 != null ? head1 : head2;
        ListNode pre = null;

        int carry = 0;
        int sum;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            l1.val = sum%10;
            l2.val = l1.val;
            carry = sum/10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            head = head1;
        }

        if (l2 != null) {
            head = head2;
        }

        while (l1 !=null) {
            sum = l1.val + carry;
            l1.val = sum%10;
            carry = sum/10;
            pre = l1;
            l1 = l1.next;
        }

        while (l2 !=null) {
            sum = l2.val + carry;
            l2.val = sum%10;
            carry = sum/10;
            pre = l2;
            l2 = l2.next;
        }

        if (carry == 1 && pre != null) {
            pre.next = new ListNode(1);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
//        l2.next = l22;
//        l22.next = l23;

        System.out.println("abcd".indexOf("cd"));
        ListNode head = addTwoNumbers(l2, l1);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }


    }
}
