package sort;

/**
 * Created by chenlijie on 8/26/17.
 */
public class Rotate_Function_396 {

    public static int maxRotateFunction(int[] A) {

        int sum = 0;
        int next = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            next += i*A[i];
        }
        int max = next;

        for (int i = 1; i < A.length; i++) {
            next = sum + next - A.length*A[A.length-i];
            max = Math.max(next, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}
