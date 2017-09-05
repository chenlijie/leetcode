package search;

/**
 * Created by chenlijie on 8/14/17.
 */
public class BinarySearch {

    public static int search(int[] source, int target) {

        int low = 0;
        int high = source.length;

        int count = 0;

        while (low < high) {

            count++;

            int middle = low + (high-low)/2;

            if (source[middle] == target) {
                return middle;
            } else if (source[middle] > target) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        System.out.println("It takes " + count + " times to search.");
        return -1;
    }

    public static void main(String[] args) {

//        System.out.println(search(new int[] {1}, 1) == 0);
//        System.out.println(search(new int[] {1, 2}, 1) == 0);
//        System.out.println(search(new int[] {1, 2}, 2) == 1);
//        System.out.println(search(new int[] {1, 2, 3}, 1) == 0);
//        System.out.println(search(new int[] {1, 2, 3}, 2) == 1);
//        System.out.println(search(new int[] {1, 2, 3}, 3) == 2);
//        System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 3) == 2);
//        System.out.println(search(new int[] {1}, 2) == -1);
//        System.out.println(search(new int[] {1}, 0) == -1);
//        System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 0) == -1);
//        System.out.println(search(new int[] {1, 2, 3, 5, 6, 7, 8}, 9) == 4);

        int[] nums = new int[1 << 9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        search(nums, 1000);
    }

}
