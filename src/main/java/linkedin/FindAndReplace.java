package linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 12/12/17.
 */
public class FindAndReplace {

    static String findAndReplace(String article, String find, String replace) {

        if (article == null || "".equals(article) || find == null || "".equals(find))
            return article;

        StringBuffer res = new StringBuffer();
        int len = find.length();

        //aba, ab, c
        int i = 0;
        while (i <= article.length()-len) {
            if (find.equals(article.substring(i, i + len))) {
                res.append(replace);
                i += len;
            } else {
                res.append(article.charAt(i));
                i++;
            }
        }
        res.append(article.substring(i));

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(findAndReplace("eabc", "ab", "d"));
        System.out.println(findAndReplace("abc", "abcd", "d"));
        System.out.println(findAndReplace("abcabcab", "ab", "d"));
        System.out.println(findAndReplace("abcabcab", "ab", ""));
        System.out.println(findAndReplace("abcabcab", "ab", "d"));


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        for (int i = 0; i < 2; i++) {
            System.out.println(list.get(i));
            list.add(i + 3);
        }

        System.out.println(list);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(1000000000);
    }
}
