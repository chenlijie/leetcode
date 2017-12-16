package medium;

import utility.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 11/4/17.
 */
public class Palindrome_Permutation_II_267 {

    public List<String> generatePalindromes(String s) {
        int[] counts = new int[256];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }

        boolean twoOdds = false;
        char single = '\u0000';
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < 256; i++) {

            if (counts[i]%2 == 1) {
                if (twoOdds) {
                    return new ArrayList<>();
                }
                twoOdds = true;
                single = (char)i;
            }

            for (int j = 0; j < counts[i] / 2; j++) {
                chars.add((char)i);
            }
        }

        List<String> results = new ArrayList<>();
        boolean[] visited = new boolean[chars.size()];
        char[] result = new char[chars.size()];

        generatePermutation(chars, visited, result, results, 0);

        for (int i = 0; i < results.size(); i++) {
            results.set(i, results.get(i) + single + reverse(results.get(i)));
        }

        return results;
    }

    private void generatePermutation(List<Character> chars, boolean[] visited, char[] result, List<String> results, int currSize) {
        if (currSize == result.length) {
            results.add(new String(result));
            return;
        }

        for (int i = 0; i < chars.size(); i++) {
            if (!visited[i]) {
                if (i > 0 && !visited[i-1] && chars.get(i-1) == chars.get(i)) {
                    continue;
                }
                visited[i] = true;
                result[currSize] = chars.get(i);
                generatePermutation(chars, visited, result, results, currSize + 1);
                visited[i] = false;
            }
        }
    }

    String reverse(String str) {
        char[] c = str.toCharArray();
        int i = 0;
        int j = c.length - 1;
        char t;

        while (i < j) {
            t = c[i];
            c[i] = c[j];
            c[j] = t;
            i++;
            j--;
        }

        return new String(c);
    }

    public static void main(String[] args) {
        Arrays.asList(new int[]{});
        Palindrome_Permutation_II_267 p = new Palindrome_Permutation_II_267();
        Utils.printStringList(p.generatePalindromes("aaaab"));
    }
}
