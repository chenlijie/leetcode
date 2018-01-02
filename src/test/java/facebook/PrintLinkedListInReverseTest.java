package facebook;

import medium.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenlijie on 12/17/17.
 */
public class PrintLinkedListInReverseTest {

    PrintLinkedListInReverse print = new PrintLinkedListInReverse();
    ListNode head = new ListNode(0);

    @Before
    public void setup() {
        ListNode cur = head;
        for (int i = 1; i < 7; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
    }

    @Test
    public void test_recursive_print() {
        print.recursivePrint(head);
    }

    @Test
    public void test_merge_print() {
        print.mergePrint(head);
    }

}