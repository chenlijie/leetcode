package microsoft.onsite;

public class IsAnagram {

    static boolean isAnagram(String s, String t) {
        int[] c = new int[256];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (c1 != c2) {
                if (c[c1]++ < 0) {
                    count--;
                } else {
                    count++;
                }

                if (c[c2]-- > 0) {
                    count--;
                } else {
                    count++;
                }
            }
        }

        System.out.println(count == 0);
        return count == 0;
    }

    public static void main(String[] args) {
        isAnagram("ab", "ba");
        isAnagram("jimmy", "jimmy");
        isAnagram("jimmy", "ymjim");
    }
}
