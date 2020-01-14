package amazon.onsite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Dice {


//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=387723&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    //假如你有一个target单词和一堆骰子（每个骰子可能有2-6个不同的字母），
    //问你能不能用这些骰子拼出target单词。每个骰子显然只能用一次。
    //然后依然是follow up，如果单词很长怎么优化，如果骰子很多怎么优化 etc. 经典DFS。


    static boolean canMakeWord(String[] dices, String word) {
        if (word == null || dices.length < word.length())
            return false;

        boolean res = dfs(dices, word, 0, new boolean[dices.length]);
        System.out.println(res);
        return res;
    }

    static boolean dfs(String[] dices, String word, int idx, boolean[] used) {
        if (idx == word.length())
            return true;

        for (int i = idx; i < dices.length; i++) {
            if (!used[i] && dices[i].indexOf(word.charAt(idx)) != -1) {
                used[i] = true;

                if (dfs(dices, word, idx + 1, used)) {
                    return true;
                }

                used[i] = false;
            }
        }

        return false;
    }


    //如果骰子很多怎么优化
    static boolean canMakeWord2(String[] dices, String word) {
        if (word == null || dices.length < word.length())
            return false;

        LinkedHashSet<Integer>[] list = new LinkedHashSet[26];

        for (int i = 0; i < dices.length; i++) {
            String dice = dices[i];
            for (Character c : dice.toCharArray()) {
                if (list[c - 'a'] == null)
                    list[c - 'a'] = new LinkedHashSet<>();
                list[c - 'a'].add(i);
            }
        }

        boolean res = dfs2(list, word, 0, new HashSet<>());
        System.out.println(res);
        return res;
    }

    static boolean dfs2(LinkedHashSet<Integer>[] list, String word, int idx, Set<Integer> set) {
        if (idx == word.length())
            return true;

        char c = word.charAt(idx);
        if (list[c - 'a'] != null) {
            for (Integer i : list[c - 'a']) {
                if (!set.contains(i)) {
                    set.add(i);
                    if (dfs2(list, word, idx + 1, set))
                        return true;
                    set.remove(i);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] dices = new String[] {
                "dabbcm",
                "dabbcc",
                "dabbck",
                "ddbacc",
                "azbbcz",
        };
        canMakeWord2(dices, "zdamka");
    }
}
