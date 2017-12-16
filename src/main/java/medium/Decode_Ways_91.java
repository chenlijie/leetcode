package medium;

/**
 * Created by chenlijie on 5/23/17.
 */
public class Decode_Ways_91 {

    public static int numDecodings4(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

    public static int numDecodings3(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] a = new int[s.length()];

        int k;
        if (s.charAt(0) == '0') {
            a[0] = 0;
            k = 0;
        } else {
            a[0] = 1;
            k = 1;
        }

        char temp = s.charAt(0);

        for (int i = 1; i < a.length; i++) {
            char c = s.charAt(i);
            if ((temp == '1' && c != '0') || (temp == '2' && c >= '1' && c <= '6')) {
                a[i] = a[i-1] + k;
            } else if ((temp != '1' && temp != '2') && c == '0') {
                return 0;
            } else if ((temp == '1' || temp == '2' )&& c == '0') {
                a[i] = k;
            } else {
                a[i] = a[i-1];
            }
            k = a[i-1];
            temp = c;
        }

        return a[a.length-1];
    }

    public static int numDecodings2(String s) {
        char[] c = s.toCharArray();
        int[][] a = new int[c.length][2];

        a[0][0] = 1;
        a[0][1] = 1;
        char temp = c[0];

        for (int i = 1; i < a.length; i++) {
            if (temp == '1' || (temp == '2' && c[i] >= '1' && c[i] <= '6')) {
                a[i][0] = a[i-1][0] + a[i-1][1];
                a[i][1] = a[i-1][0];
            } else {
                a[i][0] = a[i-1][0];
                a[i][1] = a[i-1][0];
            }
            temp = c[i];

        }

        return a[a.length-1][0];
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int len = s.length();
        char[] nums = s.toCharArray();

        int first = 1;
        int second = 1;
        int current = 1;

        for (int i = 1; i < len; i++) {
            if ((nums[i-1] == '0' || nums[i-1] >= '3') && nums[i] == '0')
                return 0;

            if ((nums[i-1] == '1' && nums[i] >= '1') || (nums[i-1] == '2' && nums[i] >= '1' && nums[i] <= '6'))
                current = first + second;
            else if (nums[i] == '0')
                current = first;
            else
                current = second;

            first = second;
            second = current;
        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("110"));
    }
}
