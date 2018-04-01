package ebay;

public class ThirdMaxInteger {


    int third(int[] nums) {
        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;
        int three = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

        }
        return 1;
    }

    public static void main(String[] args) {
//        System.out.println('\u0061');
//        System.out.println("\u0061\u0070");
//
//        System.out.println((int)'\u0061');

        String s = "\u0061\u0070";
        System.out.println(s.length());

        String t = s;
        System.out.println(t.length());

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}
