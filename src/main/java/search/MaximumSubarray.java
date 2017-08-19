package search;

/**
 * Created by chenlijie on 8/15/17.
 */
public class MaximumSubarray {

    //O(n)
    public static int maximum(int[] array) {
        int maxHere = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {

            maxHere = Math.max(maxHere + array[i], array[i]);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arrayOne = new int[] {3, 1, -8, 1, 2, -2, -3, 9, 1, -4, 5, -9, 5, 1};
        System.out.println(maximum(arrayOne));
    }
}
