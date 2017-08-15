package search;

/**
 * Created by chenlijie on 8/14/17.
 */
public class BinarySearch {

    public static int search(int[] source, int target) {

        int low = 0;
        int high = source.length;

        while (low < high) {

            int middle = low + (high-low)/2;

            if (source[middle] == target) {
                return middle;
            } else if (source[middle] > target) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

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
        System.out.println(search(new int[] {1, 2, 3, 5, 6, 7, 8}, 9) == 4);
    }
}
