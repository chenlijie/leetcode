package search;

/**
 * Created by chenlijie on 8/14/17.
 */
public class BinarySearchFindInsertIndex {

    public static int search(int[] source, int target) {

        int low = 0;
        int high = source.length;

        while (low < high) {

            int middle = low + (high-low)/2;

            if (source[middle] >= target) {
                high = middle - 1;
            } else {
                low = middle;
            }
        }

        System.out.println("low = " + low);
        System.out.println("high = " + high);
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(search(new int[] {1, 3, 5}, 4));
//        System.out.println(search(new int[] {1, 2}, 1) == 0);
//        System.out.println(search(new int[] {1, 2}, 2) == 1);
//        System.out.println(search(new int[] {1, 2, 3}, 1) == 0);
//        System.out.println(search(new int[] {1, 2, 3}, 2) == 1);
//        System.out.println(search(new int[] {1, 2, 3}, 3) == 2);
//        System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 3) == 2);
//        System.out.println(search(new int[] {1}, 2) == -1);
//        System.out.println(search(new int[] {1}, 0) == -1);
//        System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 0) == -1);
//        System.out.println(search(new int[] {1, 2, 3, 5, 6, 7, 8}, 9) == -1);
//        System.out.println(search(new int[] {1, 2, 3, 5, 6, 7, 8}, 0) == -1);

    }

}
