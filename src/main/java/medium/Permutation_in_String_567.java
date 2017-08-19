package medium;

/**
 * Created by chenlijie on 8/18/17.
 */
public class Permutation_in_String_567 {

    public static boolean checkInclusion(String s1, String s2) {

        int count = s1.length();
        int[] targets = new int[256];
        int[] visits = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            targets[s1.charAt(i)]++;
        }

        int j = 0;
        for (int i = 0; i < s2.length(); i++) {

            if (targets[s2.charAt(i)] != 0) {
                visits[s2.charAt(i)]++;
                count--;

                while (visits[s2.charAt(i)] > targets[s2.charAt(i)]) {
                    visits[s2.charAt(j++)]--;
                    count++;
                }
            } else {
                while (j <= i) {
                    visits[s2.charAt(j++)] = 0;
                }
                count = s1.length();
            }

            if (count == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("rmqqh", "nrsqrqhrymf"));
    }
}
