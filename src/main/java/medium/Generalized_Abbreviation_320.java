package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 11/7/17.
 */
public class Generalized_Abbreviation_320 {

    static List<String> generateAbbreviations(String word) {
        if (word == null || word.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        generateAbbreviations(word, 0, result);
        return result;
    }

    static void generateAbbreviations(String word, int start, List<String> result) {

        for (int i = 1; i <= word.length(); i++) {

            for (int j = start; j < word.length(); j++) {
                if (i + j <= word.length()) {
                    String abb = word.substring(0, j) + i + word.substring(i + j);
                    result.add(abb);
                    generateAbbreviations(abb, j + String.valueOf(i).length() + 1, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateAbbreviations("wordjimmychen"));
    }
}
