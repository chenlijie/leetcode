package easy;

public class Sum_of_Two_Integers_371 {

    public static int getSum(int a, int b) {

        return b != 0 ? getSum(a^b, (a&b) << 1) : a;
//        return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static int getSum2(int a, int b) {

        int temp;
        while (b != 0) {
            temp = a^b;
            b = (a&b) << 1;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(-1, 1));
        System.out.println(getSum2(-1, 1));
    }
}
