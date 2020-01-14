package amazon.onsite;

public class DivideWithoutDivider {

    //9/2, -9/2
    //a = b * c
    static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend^divisor) < 0 ? -1 : 1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        int ans = 0;

        while (ldividend >= ldivisor) {
            int shift = 0;

            while (ldividend >= ldivisor<<shift)
                shift++;

            ldividend -= ldivisor<<(shift-1);
            ans += 1<<(shift-1);
        }

        return ans * sign;
    }

    public static void main(String[] args) {
        System.out.println(divide(15, 2));
    }
}
