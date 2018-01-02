package search;

/**
 * Created by chenlijie on 8/14/17.
 */
public class BinarySearchLowerBound {

    public static int search(int[] source, int target) {

        int low = 0;
        int high = source.length;

        while (low < high) {

            int middle = low + (high-low)/2;

            if (source[middle] > target) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        System.out.println(search(new int[] {1, 2, 2,2,2,2,2,3}, 2));

        int[] a = new int[Integer.MAX_VALUE];
    }

}
