package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 11/5/17.
 */
public class Verify_Preorder_Sequence_in_Binary_Search_Tree_255 {

    /**
     Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

     You may assume each number in the sequence is unique.

     Follow up:
     Could you do it using only constant space complexity?
     */

    static boolean verify(int[] nums) {
        if (nums == null) {
            return true;
        }
        return verify(nums, 0, nums.length - 1);
    }

    static boolean verify(int[] nums, int rootIdx, int treeEnd) {
        if (rootIdx >= treeEnd) {
            return true;
        }
        int leftEnd = getLeftSubTreeEnd(nums, rootIdx, treeEnd);

        int rootVal = nums[rootIdx];
        int rightStart = leftEnd + 1;

        for (int i = rightStart; i <= treeEnd; i++) {
            if (rootVal > nums[i]) {
                return false;
            }
        }

        int leftStart = rootIdx + 1;
        for (int i = leftStart; i <= leftEnd; i++) {
            if (nums[i] > rootVal) {
                return false;
            }
        }

        return verify(nums, leftStart, leftEnd) && verify(nums, rightStart, treeEnd);
    }

    static int getLeftSubTreeEnd(int[] nums, int rootIdx, int end) {
        for (int i = rootIdx + 1; i <= end; i++) {
            if (nums[i] > nums[rootIdx]) {
                return i-1;
            }
        }
        return end;
    }

    static boolean verify2(int[] nums) {
        if (nums == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < low) {
                return false;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                low = stack.pop();
            }
            stack.push(nums[i]);
        }

        return true;
    }

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> inorder = new Stack<>();

        for(int v : preorder){
            if(!inorder.isEmpty() && v < inorder.peek())
                return false;
            while(!stack.isEmpty() && v > stack.peek()){
                inorder.push(stack.pop());
            }
            stack.push(v);
        }
        return true;
    }

    // verify post order
    public static boolean isValidPostOrderBST(int[] nums)
    {
        int i = nums.length;
        int root = Integer.MAX_VALUE;
        for (int j = nums.length - 1; j >= 0; j--)
        {
            if (nums[j] > root) return false;
            while (i <= nums.length - 1 && nums[j] > nums[i])
                root = nums[i++];
            nums[--i] = nums[j];
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(verify2(new int[]{4, 1, 2, 5, 6}));
        System.out.println(verify(null));
    }
}
