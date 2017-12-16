package medium;

/**
 * Created by chenlijie on 10/29/17.
 */
public class Trie2 {

    private Trie2[] tries;
    private String word;

    /** Initialize your data structure here. */
    public Trie2() {
        tries = new Trie2[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word != null || word.length() > 0) {
            insert(word, 0);
        }
    }

    private void insert(String word, int start) {

        int index = word.charAt(start) - 'a';
        if (tries[index] == null) {
            tries[index] = new Trie2();
        }

        if (word.length()-1 == start) {
            tries[index].word = word;
        } else {
            tries[index].insert(word, start+1);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return search(word, 0);
    }

    private boolean search(String word, int start) {

        int index = word.charAt(start) - 'a';
        if (tries[index] == null) {
            return false;
        } else {
            if (start == word.length()-1) {
                if (word.equals(tries[index].word)) {
                    return true;
                } else {
                    return false;
                }
            }
            return tries[index].search(word, start+1);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        return startsWith(prefix, 0);
    }

    private boolean startsWith(String prefix, int start) {

        int index = prefix.charAt(start) - 'a';
        if (tries[index] == null) {
            return false;
        } else {
            if (start == prefix.length()-1) {
                return true;
            }
            return tries[index].startsWith(prefix, start+1);
        }
    }

    public static void main(String[] args) {

          Trie2 obj = new Trie2();
        obj.insert("app");
        obj.insert("apps");

//          boolean param_2 = obj.search("a");
          boolean param_3 = obj.search("app");

//        System.out.println(param_2);
        System.out.println(param_3);

    }
}
