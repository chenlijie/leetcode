package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by chenlijie on 4/14/17.
 */
public class Roman_to_Integer_13 {

    /*
        I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1000

        VI 6
        VII 7
        VIII 8
        IX 9

        XIX 19
        XXV 25

        XIXX
    */
    public static int romanToInt(String s) {
        if (s == null || s.isEmpty())
            return -1;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // I,X,C,M max continues count is 3
        // V,L,D can't follow itself
        // V can't be on the left of X, the right element of X can't be V
        // L can't be on the left of C
        // D can't be on the left of M
        // only can go down 1 time, the go down number should near the smallest number
        // XCIX 99 IC
        // XCIV 94
        // CXLIX 149 CIL

//        1.  I、X、C在大数右边（即相加时）不能连续超过三个，在大数左边（即相减时）只能用一个。
//        2.  V、L、D不能用于大数左边（相减），只能用于大数右边（相加），且只使用一个。
//        3.  V、X左边小数只用I；L、C左边小数只用X；D、M左边小数只用C。

        int ans = 0;
        int last = s.length() - 1;
        int first = -1;
        int second = -1;
        int third = -1;

        for (int i = last; i >= 0; i--) {
            int cur = map.getOrDefault(s.charAt(i), -1);

            if (cur == -1)
                return -1;

            if ((cur == 5 || cur == 50 || cur == 500) && cur == first)
                return -1;

            if (cur == first && cur == second && cur == third)
                return -1;

            if (cur < first) {
                if ((cur == 1 && first != 5 && first != 10)
                        || (cur == 10 && first != 50 && first != 100)
                        || (cur == 100 && first != 500 && first != 1000))
                    return -1;

                ans -= cur;
            } else {
                ans += cur;
            }

            third = second;
            second = first;
            first = cur;
        }

        return ans;
    }

    static int romanToInt2(String s) {
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int ans = 0;
        int offset = 0;
        for (int i = 0; i < letters.length; i++) {
            while (s.startsWith(letters[i], offset)) {
                ans += nums[i];
                offset += i % 2 == 0 ? 1 : 2;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//      I: 1,    V: 5
//      X: 10    L: 50
//      C: 100   D: 500
//      M: 1000
        // I,X,C,M max continues count is 3
        // V,L,D can't follow itself
        // V can't be on the left of X, the right element of X can't be V
        // L can't be on the left of C
        // D can't be on the left of M
        // only can go down 1 time, compare with the max number we already see

        //MMMDCCCLXXXVIII

        // XIX 19 IXX
        // IIV 3 III
        // LXXXXV 95 VC
        // VXXC 75 LXXV
        // VXXXL 65 LXV
        // XXXXC 60 LX
        // LXXXX 90 XC
        // LXXVXI 76 LXXVI
        // VXIV 9 IX
        // XCIX 99 IC
//        System.out.println(romanToInt("IIII"));
//        System.out.println(romanToInt("VV"));
//        System.out.println(romanToInt("IX"));
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("IC"));
//        System.out.println(romanToInt("XL"));
//        System.out.println(romanToInt("XXXVI"));
//        System.out.println(romanToInt("XXXIV"));
//        System.out.println(romanToInt("VIV"));
//        System.out.println(romanToInt("VV"));
//        System.out.println(romanToInt("LL"));
//        System.out.println(romanToInt("MMMDCCCLXXXIV"));
//        System.out.println(romanToInt("ICLXV"));
//        System.out.println(romanToInt("IMMMC"));
//        System.out.println(romanToInt("IM"));

        System.out.println(new Random().nextDouble());
    }
}
