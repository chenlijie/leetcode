package medium;

/**
 * Created by chenlijie on 8/17/17.
 */
public class Bulls_and_Cows_299 {

    public static String getHint(String secret, String guess) {

        int[] counts = new int[10];
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (counts[secret.charAt(i) - '0']++ < 0) {
                    cows++;
                }
                if (counts[guess.charAt(i) - '0']-- > 0) {
                    cows++;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }
}
