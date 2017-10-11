package hard;

import sort.Node;
import utility.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 9/15/17.
 */
public class Count_of_Smaller_Numbers_After_Self_315 {

    static class Node {
        int val;
        int less;
        int same = 1;
        Node left;
        Node right;

        public Node(int val, int less) {
            this.val = val;
            this.less = less;
        }
    }

    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> counts = new ArrayList<>();

        Node node = null;
        for (int i = nums.length-1; i >= 0; i--) {
            node = build(node, nums[i], 0, counts);
        }

        return counts;
    }

    private Node build(Node node, int val, int less, List<Integer> counts) {
        if (node == null) {
            counts.add(0, less);
            return new Node(val, less);
        }

        if (val == node.val) {
            node.same++;
            counts.add(0, node.less);
        } else if (val > node.val) {
            if (node.right != null) {
                node.right.less = node.less + node.same + (node.right.left != null ? node.right.left.less + node.right.left.same : 0);
            }
            node.right = build(node.right, val, node.less+node.same, counts);
        } else {
            node.less++;
            if (node.left != null) {
                node.left.less = node.less - 1;
            }
            node.left = build(node.left, val, node.less-1, counts);
        }

        return node;
    }


    /*

    Let's divide array to two parts - left and right. If each num from right part is counted and sorted,
    it's straightforward to do count for each num from left part. Just iterate each from left part and compare with right part.

    So the idea looks like below steps :
    1. count each number from right part and sort right part.
    2. count each number from left part. As right part is sorted, we can do binary search to find how many number from right part
       are less than it. Then sort left part.
    3. Left and right part are sorted, merge them.

     */

    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        countAndSort(nums, 0, nums.length, count);

        List<Integer> list = new ArrayList<>();
        for (int i : count) {
            list.add(i);
        }

        return list;
    }

    private void countAndSort(int[] nums, int begin, int end, int[] count) {
        if (end - 1 <= begin) {
            return;
        }

        int mi = (begin + end)/2;
        countAndSort(nums, mi, end, count);

        for (int i = begin; i < mi; i++) {
            count[i] += binarySearch(nums, mi, end, nums[i]) - mi;
        }

        countAndSort(nums, begin, mi, count);
        mergeArrays(nums, begin, mi, end);
    }

    private void mergeArrays(int[] nums, int begin, int mi, int end) {
        int i = begin;
        int j = mi;
        int[] temp = new int[end];
        int k = 0;

        while (i < mi && j < end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i < mi) {
            temp[k++] = nums[i++];
        }

        while (j < end) {
            temp[k++] = nums[j++];
        }

        k = 0;
        for (int l = begin; l < end; l++) {
            nums[l] = temp[k++];
        }
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mi = lo + (hi - lo)/2;

            if (target > nums[mi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
//        System.out.println(binarySearch(new int[]{2, 3, 4, 6}, 0 ,4, 7));


//        int[] nums1 = new int[] {99,51,9,21,84,66,65,36,100,41};
//        int[] nums = new int[] {4,1,2,3};
//        Utils.printList(new Count_of_Smaller_Numbers_After_Self_315().countSmaller(nums1));

        int[] nums = new int[] {5,2,6,1};//new int[] {99,51,9,21,84,66,65,36,100,41};
        Utils.printList(new Count_of_Smaller_Numbers_After_Self_315().countSmaller(nums));
    }
}
