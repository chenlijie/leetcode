package hard;

import medium.ListNode;

/**
 * Created by chenlijie on 9/13/17.
 */
public class Merge_k_Sorted_Lists_23_2 {

    //Time complexity O(n*k*logn)
    //n is lists length;
    //k is the average size of each list;
    public ListNode mergeKListts(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        int l = 0;
        int r = lists.length - 1;

        while (l <= r) {
            while (l <= r && lists[l] != null) {
                l++;
            }
            while (l <= r && lists[r] == null) {
                r--;
            }

            if (l < r) {
                swap(l, r, lists);
            }
        }

        int size = l;
        for (int i = l/2 - 1; i >= 0; i--) {
            buildMinHeap(i, size, lists);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (size > 0) {
            ListNode node = lists[0];
            cur.next = node;
            cur = cur.next;

            lists[0] = lists[0].next;
            if (lists[0] == null) {
                lists[0] = lists[size - 1];
                size--;
            }
            buildMinHeap(0, size, lists);
        }
        cur.next = null;

        return dummy.next;
    }

    void swap(int i, int j, ListNode[] lists) {
        ListNode t = lists[i];
        lists[i] = lists[j];
        lists[j] = t;
    }

    void buildMinHeap(int i, int size, ListNode[] lists) {
        int largest = i;
        if (2*i + 1 < size && lists[2*i + 1].val > lists[largest].val) {
            largest = 2*i + 1;
        }
        if (2*i + 2 < size && lists[2*i + 2].val > lists[largest].val) {
            largest = 2*i + 2;
        }
        if (largest != i) {
            swap(largest, i, lists);
            buildMinHeap(largest, size, lists);
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

        ListNode node = new Merge_k_Sorted_Lists_23_2().mergeKListts(new ListNode[]{list2});
//        ListNode node = new Merge_k_Sorted_Lists_23().mergeKLists2(new ListNode[]{list1, list2});
//        ListNode node = new Merge_k_Sorted_Lists_23().mergeKLists2(new ListNode[]{null,null,null});

        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }
}
