package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 8/17/17.
 */
public class Replace_Words_648 {

    public static String replaceWords(List<String> dict, String sentence) {
        //initialize dict
        Trie dicts = new Trie('$');
        for (String root : dict) {
            Trie parent = dicts;
            for (int i = 0; i < root.length(); i++) {

                if (parent.tries[root.charAt(i) - 'a'] == null) {
                    parent.tries[root.charAt(i) - 'a'] = new Trie(root.charAt(i));
                }

                if (i == root.length() - 1) {
                    parent.tries[root.charAt(i) - 'a'].root = root;
                }

                parent = parent.tries[root.charAt(i) - 'a'];
            }
        }

        StringBuilder builder = new StringBuilder("");

        for (String word : sentence.split(" ")) {

            int i = 0;
            Trie trie = dicts.tries[word.charAt(i) - 'a'];

            while (trie != null && ++i < word.length()) {

                if (trie.root != null) {
                    word = trie.root;
                    break;
                }
                trie = trie.tries[word.charAt(i) - 'a'];
            }

            builder.append(word);
            builder.append(" ");
        }

        return builder.toString().trim();
    }

    static class Trie {
        String root;
        char letter;
        Trie[] tries;

        public Trie(char letter) {
            this.letter = letter;
            tries = new Trie[26];
        }
    }

    public static void main(String[] args) {

        String[] strs = new String[] {"e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"};
        List<String> list = new ArrayList<>();
        for (String s : strs) {
            list.add(s);
        }

        System.out.println(replaceWords(list, "r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"));
    }

}
