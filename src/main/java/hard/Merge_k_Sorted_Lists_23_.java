package hard;

import medium.ListNode;

import java.util.PriorityQueue;

/**
 * Created by chenlijie on 9/13/17.
 */
public class Merge_k_Sorted_Lists_23_ {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        //lists = removeNull(lists);
        int i = 0;
        int j = lists.length - 1;

        while (i < j) {
            while (i < j && lists[i] != null) {
                i++;
            }

            while (i < j && lists[j] == null) {
                j--;
            }

            if (i < j) {
                ListNode t = lists[i];
                lists[i] = lists[j];
                lists[j] = t;
                i++;
                j--;
            }
        }

        int len = i;//lists.length;

        if (len == 0)
            return null;

        for (i = len/2-1; i >= 0; i--) {
            heapify(lists, i, len);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int size = len;

        while (size > 0) {
            cur.next = lists[0];
            cur = cur.next;
            lists[0] = lists[0].next;

            if (lists[0] == null) {
                lists[0] = lists[--size];
            }

            if (lists[0] != null) {
                heapify(lists, 0, size);
            }
        }
        return dummy.next;
    }


    void heapify(ListNode[] lists, int i, int len) {
        int smallest = i;

        if (2*i + 1 < len && lists[2*i + 1].val < lists[smallest].val) {
            smallest = 2*i + 1;
        }

        if (2*i + 2 < len && lists[2*i + 2].val < lists[smallest].val) {
            smallest = 2*i + 2;
        }

        if (smallest != i) {
            ListNode t = lists[smallest];
            lists[smallest] = lists[i];
            lists[i] = t;
            heapify(lists, smallest, len);
        }
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode cur = list1;
        int i = 3;
        while (i < 10) {
            cur.next = new ListNode(i);
            cur = cur.next;
            i += 2;
        }

        ListNode list2 = new ListNode(2);
        cur = list2;
        i = 4;
        while (i < 10) {
            cur.next = new ListNode(i);
            cur = cur.next;
            i += 2;
        }

        ListNode node = new Merge_k_Sorted_Lists_23_().mergeKLists(new ListNode[]{list2});
//        ListNode node = new Merge_k_Sorted_Lists_23().mergeKLists2(new ListNode[]{list1, list2});
//        ListNode node = new Merge_k_Sorted_Lists_23().mergeKLists2(new ListNode[]{null,null,null});

        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }
}
