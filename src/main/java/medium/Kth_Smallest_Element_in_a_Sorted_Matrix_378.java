package medium;

/**
 * Created by chenlijie on 5/15/17.
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {


    //heap sort O(N*logN)
    public int kthSmallest(int[][] matrix, int k) {

        int c = matrix[0].length;
        int r = matrix.length;
        int len = r * c;


        for (int i = (len/2 - 1); i >= 0; i--) {
            heapify(i, c, len, matrix);
        }

        int i = len-1;
        for (; i >= k-1; i--) {
            int temp = matrix[i/c][i%c];
            matrix[i/c][i%c] = matrix[0][0];
            matrix[0][0] = temp;

            heapify(0, c, i, matrix);
        }

        return matrix[(i+1)/c][(i+1)%c];
    }

    private void heapify(int i, int c, int len, int[][] matrix) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < len && matrix[l/c][l%c] > matrix[largest/c][largest%c]) {
            largest = l;
        }

        if (r < len && matrix[r/c][r%c] > matrix[largest/c][largest%c]) {
            largest = r;
        }

        if (largest != i) {
            int temp = matrix[largest/c][largest%c];
            matrix[largest/c][largest%c] = matrix[i/c][i%c];
            matrix[i/c][i%c] = temp;

            heapify(largest, c, len, matrix);
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[3][3];
//        matrix[0] = new int[]{1,  5,  9};
//        matrix[1] = new int[]{10, 11, 13};
//        matrix[2] = new int[]{12, 13, 15};

        int[][] matrix = new int[][] {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };

        System.out.println(new Kth_Smallest_Element_in_a_Sorted_Matrix_378().kthSmallest(matrix, 4));
    }

}
