package tweeter;

public class LongestPhrase {

    //https://www.careercup.com/question?id=5676572716564480
    static int longestPhrase(int[] phrase, int k) {
        int max = 0;
        int sum = 0;

        for (int i = 0, j = 0; i < phrase.length; i++) {
            sum += phrase[i];

            if (sum <= k) {
                max = Math.max(max, i - j + 1);
            } else {
                while (sum > k) {
                    sum -= phrase[j++];
                }
                max = Math.max(max, i - j + 1);
            }
        }

        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
//        longestPhrase(new int[] {1,2,3}, 3);
//        longestPhrase(new int[] {1,2,3}, 0);
        longestPhrase(new int[] {1,2,3,1,1,2}, 4);
        longestPhrase(new int[] {1,2,3,1,1,2, 1,1,1,1}, 4);
    }
}
