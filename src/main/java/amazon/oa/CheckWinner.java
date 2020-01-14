package amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckWinner {

    static int checkWinner( List<List<String>> codeList, List<String> shoppingCart ) {

        int idx = 0;
        for (List<String> codes : codeList) {
            idx = find(idx, codes, shoppingCart);
            if (idx == -1)
                return 0;
        }

        return 1;
    }

    static int find(int start, List<String> codes, List<String> shoppingCart) {
        for (int i = start; i <= shoppingCart.size() - codes.size(); i++) {
            int j = i;
            int k = 0;
            for (; k < codes.size(); k++) {
                if (!shoppingCart.get(j++).equals(codes.get(k)) && !"anything".equals(codes.get(k)))
                    break;
            }

            if (k == codes.size())
                return j;
        }

        return -1;
    }

    public static void main(String[] args) {
//        List<List<String>> codeList = new ArrayList<>();
//        codeList.add(Arrays.asList("apple", "apple"));
//        codeList.add(Arrays.asList("banana", "anything", "banana"));
//        List<String> shoppingCart = Arrays.asList("apple", "apple", "apple", "banana", "orange", "banana");

//        List<List<String>> codeList = new ArrayList<>();
//        codeList.add(Arrays.asList("orange"));
//        codeList.add(Arrays.asList("apple", "apple"));
//        codeList.add(Arrays.asList("banana", "orange", "banana"));
//        codeList.add(Arrays.asList("banana"));
//        List<String> shoppingCart = Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana", "banana");

//        List<List<String>> codeList = new ArrayList<>();
//        codeList.add(Arrays.asList("apple", "apricot"));
//        codeList.add(Arrays.asList("banana", "anything", "guava"));
//        codeList.add(Arrays.asList("papaya", "anything"));
//        List<String> shoppingCart = Arrays.asList("banana", "anything", "guava","apple", "apricot","papaya", "kiwi");

        List<List<String>> codeList = new ArrayList<>();
        codeList.add(Arrays.asList("apple", "apple"));
        codeList.add(Arrays.asList("apple", "apple", "banana"));
        List<String> shoppingCart = Arrays.asList("apple", "apple", "apple", "banana");

        System.out.println(checkWinner(codeList, shoppingCart));
    }
}
