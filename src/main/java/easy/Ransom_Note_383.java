package easy;

/**
 * Created by chenlijie on 8/6/17.
 */
public class Ransom_Note_383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[58];

        for (int i = 0; i < ransomNote.length(); i++) {
            counts[ransomNote.charAt(i)-'A']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i)-'A']--;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aAZzz", "bdfeadsfZsdfzeteA"));
    }
}
