package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 5/14/17.
 */
public class _4Sum_II_454 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int count = 0;

        Map<Integer, Integer> ab = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                ab.putIfAbsent(A[i]+B[j], 0);
                ab.put(A[i]+B[j], ab.get(A[i]+B[j]) + 1);
            }
        }

        Map<Integer, Integer> cd = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                cd.putIfAbsent(C[i]+D[j], 0);
                cd.put(C[i]+D[j], cd.get(C[i]+D[j]) + 1);
            }
        }

        for (int i : ab.keySet()) {
            if (cd.get(0-i) != null) {
                count += ab.get(i)*cd.get(0-i);
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
