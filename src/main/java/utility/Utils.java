package utility;

import medium.ListNode;

import java.util.List;

/**
 * Created by chenlijie on 9/14/17.
 */
public class Utils {

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void printNodes(ListNode node) {
        ListNode n = node;
        while (n != null) {
            System.out.print(n.val + "  ");
            n = n.next;
        }
        System.out.println();
    }
}
