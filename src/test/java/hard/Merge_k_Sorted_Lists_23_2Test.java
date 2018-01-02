package hard;

import medium.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenlijie on 12/17/17.
 */
public class Merge_k_Sorted_Lists_23_2Test {
    @Test
    public void mergeKListts() throws Exception {
        Merge_k_Sorted_Lists_23_2 merge = new Merge_k_Sorted_Lists_23_2();
        ListNode node = merge.mergeKListts(new ListNode[] {null});
        assertTrue(node == null);
    }

    @Test
    public void mergeKListts2() throws Exception {
        Merge_k_Sorted_Lists_23_2 merge = new Merge_k_Sorted_Lists_23_2();
        ListNode node1 = new ListNode(10);
        ListNode cur = node1;
        for (int i = 0; i < 2; i++) {
            ListNode newNode = new ListNode(cur.val - 3);
            cur.next = newNode;
            cur = cur.next;
        }

        ListNode node2 = new ListNode(15);
        cur = node2;
        for (int i = 0; i < 2; i++) {
            ListNode newNode = new ListNode(cur.val - 3);
            cur.next = newNode;
            cur = cur.next;
        }

        ListNode node3 = new ListNode(8);
        cur = node3;
        for (int i = 0; i < 2; i++) {
            ListNode newNode = new ListNode(cur.val - 3);
            cur.next = newNode;
            cur = cur.next;
        }

        ListNode ans = merge.mergeKListts(new ListNode[] {node1, node2, node3});
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println();
        assertTrue(ans == null);
    }

}