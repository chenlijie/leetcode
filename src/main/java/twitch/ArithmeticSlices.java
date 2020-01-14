package twitch;

public class ArithmeticSlices {
    static int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0)
            return 0;

        int total = 0;
        int len = A.length;
        int cur = 0;

        for (int i = 2; i < len; i++) {
            if (A[i - 2] - A[i - 1] == A[i - 1] - A[i]) {
                cur++;
                total += cur;
            } else {
                cur = 0;
            }
        }

        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        numberOfArithmeticSlices(new int[] {1,2,3,4});
    }
}
