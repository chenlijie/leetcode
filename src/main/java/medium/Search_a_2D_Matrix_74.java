package medium;

/**
 * Created by chenlijie on 8/14/17.
 */
public class Search_a_2D_Matrix_74 {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int low = 0;
        int high = matrix.length;

        while (high - low >= 1) {

            int middle = low + (high-low)/2;

            if (matrix[middle][0] == target) {
                return true;
            } else if (matrix[middle][0] > target) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        if (low != 0) {
            low -= 1;
        }

        int l = 0;
        int h = matrix[0].length;

        while (h - l >= 1) {

            int m = l + (h-l)/2;

            if (matrix[low][m] == target) {
                return true;
            } else if (matrix[low][m] > target) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return l < matrix[0].length && matrix[low][l] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
//                {1,1}
//                {1, 3, 5}
//                {10, 13, 16}
//                { 1,  3,  5,  7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
                {1},
                {3},
                {5}
        };

//        System.out.println(searchMatrix(matrix, 1));
        System.out.println(searchMatrix(matrix, 5));
//        System.out.println(searchMatrix(matrix, 3) == true);
//        System.out.println(searchMatrix(matrix, 5) == true);
//        System.out.println(searchMatrix(matrix, 8) == false);


//        System.out.println(searchMatrix(matrix, 8) == false);
//        System.out.println(searchMatrix(matrix, 10) == true);
//        System.out.println(searchMatrix(matrix, 13) == true);
//        System.out.println(searchMatrix(matrix, 15) == false);
//        System.out.println(searchMatrix(matrix, 16) == true);
//        System.out.println(searchMatrix(matrix, 20) == false);
    }
}
