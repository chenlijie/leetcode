package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 5/1/17.
 */
public class Remove_Nth_Node_From_End_of_List_19 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 0, 1, 2, 3, 4, 5
     *
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer, ListNode> map = new HashMap<>();
        int idx = 0;

        ListNode node = head;

        while (node != null) {
            map.put(idx++, node);
            node = node.next;
        }

        if (idx == n) {
            head = head.next;
        } else if (1 == n) {
            map.get(idx-2).next = null;
        } else {
            map.get(idx-n-1).next = map.get(idx-n+1);
        }

        return head;

    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    static void test1() {
        Remove_Nth_Node_From_End_of_List_19.ListNode head = new Remove_Nth_Node_From_End_of_List_19.ListNode(1);
        System.out.println(removeNthFromEnd(head, 1));
    }

    static void test2() {
        Remove_Nth_Node_From_End_of_List_19.ListNode head = new Remove_Nth_Node_From_End_of_List_19.ListNode(1);
        Remove_Nth_Node_From_End_of_List_19.ListNode node1 = new Remove_Nth_Node_From_End_of_List_19.ListNode(2);
        Remove_Nth_Node_From_End_of_List_19.ListNode node2 = new Remove_Nth_Node_From_End_of_List_19.ListNode(3);
        Remove_Nth_Node_From_End_of_List_19.ListNode node3 = new Remove_Nth_Node_From_End_of_List_19.ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node = removeNthFromEnd(head, 1);
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }

    }

    static void test3() {
        Remove_Nth_Node_From_End_of_List_19.ListNode head = new Remove_Nth_Node_From_End_of_List_19.ListNode(1);
        Remove_Nth_Node_From_End_of_List_19.ListNode node1 = new Remove_Nth_Node_From_End_of_List_19.ListNode(2);
        Remove_Nth_Node_From_End_of_List_19.ListNode node2 = new Remove_Nth_Node_From_End_of_List_19.ListNode(3);
        Remove_Nth_Node_From_End_of_List_19.ListNode node3 = new Remove_Nth_Node_From_End_of_List_19.ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node = removeNthFromEnd(head, 4);
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }

    }

    static void test4() {
        Remove_Nth_Node_From_End_of_List_19.ListNode head = new Remove_Nth_Node_From_End_of_List_19.ListNode(1);
        Remove_Nth_Node_From_End_of_List_19.ListNode node1 = new Remove_Nth_Node_From_End_of_List_19.ListNode(2);
        Remove_Nth_Node_From_End_of_List_19.ListNode node2 = new Remove_Nth_Node_From_End_of_List_19.ListNode(3);
        Remove_Nth_Node_From_End_of_List_19.ListNode node3 = new Remove_Nth_Node_From_End_of_List_19.ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node = removeNthFromEnd(head, 2);
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }

    }
}
