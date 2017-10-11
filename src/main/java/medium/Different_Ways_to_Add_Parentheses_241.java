package medium;

import java.util.*;

/**
 * Created by chenlijie on 9/13/17.
 */
public class Different_Ways_to_Add_Parentheses_241 {

    public List<Integer> diffWaysToCompute(String input) {

        return getNumbers(input, new HashMap<>());
    }

    private List<Integer> getNumbers(String input, Map<String, List<Integer>> map) {

        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            return Arrays.asList(Integer.valueOf(input));
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = map.getOrDefault(input.substring(0, i), getNumbers(input.substring(0, i), map));
                List<Integer> right = map.getOrDefault(input.substring(i+1, input.length()), getNumbers(input.substring(i+1, input.length()), map));

                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if (input.charAt(i) == '+') {
                            numbers.add(left.get(j) + right.get(k));
                        } else if (input.charAt(i) == '-') {
                            numbers.add(left.get(j) - right.get(k));
                        } else {
                            numbers.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }
        map.put(input, numbers);
        return numbers;
    }

    public static void main(String[] args) {
        for (int i : new Different_Ways_to_Add_Parentheses_241().diffWaysToCompute("2*3-4*5")) {
            System.out.print(i + "  ");
        }
    }
}
