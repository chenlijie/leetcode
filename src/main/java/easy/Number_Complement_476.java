package easy;

public class Number_Complement_476 {

    public static int findComplement(int num) {
        return cal(num, 0);
    }

    static int cal(int num, int k) {
        if (num/2 == 0) {
            return num==1?0:1;
        }
        return (num%2+1)%2 * (int)Math.pow(2,k) + cal(num/2, ++k);
    }

    public static int findComplement_2(int num) {
        if (num/2 == 0) {
            return num==1?0:1;
        }
        return (num%2+1)%2 + findComplement_2(num/2) * 2;
    }
    public static int findComplement_3(int num) {
        return 1;
    }
}
