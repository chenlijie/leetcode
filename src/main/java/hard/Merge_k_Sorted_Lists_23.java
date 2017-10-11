package hard;

import medium.ListNode;

import java.util.PriorityQueue;

/**
 * Created by chenlijie on 9/13/17.
 */
public class Merge_k_Sorted_Lists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        int len = lists.length;
        int i = 0;
        int maxNode = 0;
        //lists may have nulls, below loop move non-null at first and re-size. so first len Listnode are not null.
        //i.e. lists : [Node1, null, Node2, null, null, Node3] and len is 6, after below loop it becomes [Node1, Node2, Node3, null, null, null] and len is 3.
        //When we do heap or sort, we only consider first 3 elements.
        while (i < len) {
            while (lists[i] == null && len-1 > i) {
                lists[i] = lists[len-1];
                len--;
            }

            if (lists[i] == null) {
                len--;
            } else if (lists[i] != null && lists[i].val > lists[maxNode].val) {
                maxNode = i;
            }
            i++;
        }

        if (len == 0) {
            return null;
        }

        //build heap, root (0-index element) has smallest val.
        for (i = len/2-1; i >= 0; i--) {
            heapify(i, len, lists);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;


        int size = len;
        while (size > 0) {
            //lists[0] has smallest value so poll it and link it after cur.
            cur.next = lists[0];
            cur = cur.next;

            //Get next Node from list[0] and do heapify, so lists[0] will holds the smallest element.
            lists[0] = lists[0].next;

            //If there is no next node from lists[0], we exchange last element from lists and reduce size.
            if (lists[0] == null) {
                size--;
                lists[0] = lists[size];
            }

            heapify(0, size, lists);
        }

        return dummy.next;
    }

    private void heapify(int s, int len, ListNode[] lists) {
        int min = s;
        int left = 2*s + 1;
        int right = 2*s + 2;

        if (left < len && lists[left] != null && lists[left].val < lists[min].val) {
            min = left;
        }

        if (right < len && lists[right] != null && lists[right].val < lists[min].val) {
            min = right;
        }

        if (min != s) {
            ListNode temp = lists[s];
            lists[s] = lists[min];
            lists[min] = temp;

            heapify(min, len, lists);
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

        ListNode node = new Merge_k_Sorted_Lists_23().mergeKLists2(new ListNode[]{list1, null, list2});
//        ListNode node = new Merge_k_Sorted_Lists_23().mergeKLists2(new ListNode[]{list1, list2});
//        ListNode node = new Merge_k_Sorted_Lists_23().mergeKLists2(new ListNode[]{null,null,null});

        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }
}
