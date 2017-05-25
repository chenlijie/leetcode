package medium;

/**
 * Created by chenlijie on 5/15/17.
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

    public static int kthSmallest(int[][] matrix, int k) {

        int[][] a = new int[matrix.length][2];
        for (int i = 0; i < a.length; i++) {
            a[i][0] = i;
            a[i][1] = 0;
        }

        int n = 0;
        int m = 0;
        int n1 = 0;
        int m1 = 0;

        for (int i = 0; i < k; i++) {
            n = n1;
            m = m1;
            for (int j = 0; j < matrix.length; j++) {
                if (a[j][1] >= matrix.length) {
                    continue;
                }
                if (matrix[a[j][0]][a[j][1]] < matrix[n][m]) {
                    n = a[j][0];
                    m = a[j][1];
                } else {
                    n1 = a[j][0];
                    m1 = a[j][1];
                }
            }
            a[n][1] += 1;

        }

        return matrix[n][m];
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[3][3];
//        matrix[0] = new int[]{1,  5,  9};
//        matrix[1] = new int[]{10, 11, 13};
//        matrix[2] = new int[]{12, 13, 15};

        int[][] matrix = new int[2][2];
        matrix[0] = new int[]{1, 2};
        matrix[1] = new int[]{1, 3};

        System.out.println(kthSmallest(matrix, 4));
    }

}
