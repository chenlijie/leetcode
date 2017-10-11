package hard;

import java.util.*;

/**
 * Created by chenlijie on 9/12/17.
 */
public class Word_Abbreviation_527 {

    /**
     *
     * Given an array of n distinct non-empty strings, you need to generate minimal
     * possible abbreviations for every word following rules below.
     * Begin with the first character and then the number of characters abbreviated, which followed by the last character.
     *
     * If there are any conflict, that is more than one words share the same abbreviation,
     * a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique.
     * In other words, a final abbreviation cannot map to more than one original words.
     * If the abbreviation doesn't make the word shorter, then keep it as original.
     *
     *
     * ixterval
     * ixterval
     * iyternel
     * iyternal
     * izterval
     *
     */
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> abb = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String word : dict) {
            abb.add(generateAbb(word, map));
        }

        return abb;
    }

    private String generateAbb(String word, Map<String, String> map) {
        int k = word.length() - 2;
        String last = word.substring(word.length() - 1);

        for (int i = 1; i < word.length()-1; i++) {
            if (!map.containsKey(word.substring(0, i) + k + last)) {
                if (k < 2) {
                    map.put(word, word);
                    return word;
                } else {
                    map.put(word.substring(0, i) + k + last, word);
                    return word.substring(0, i) + k + last;
                }
            }
            k--;
        }
        return word;
    }

    //Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
    //Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]

    public static void main(String[] args) {
//        List<String> dict = Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion");
        List<String> dict = Arrays.asList("internal", "interval");
        for (String word : new Word_Abbreviation_527().wordsAbbreviation(dict)) {
            System.out.print(word + "  ");
        }
    }
}
