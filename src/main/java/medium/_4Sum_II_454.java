package medium;

/**
 * Created by chenlijie on 5/14/17.
 */
public class _4Sum_II_454 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if (A[i]+B[j]+C[k]+D[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{ 0, 2};

        System.out.println(fourSumCount(A,B,C,D));
    }
}
