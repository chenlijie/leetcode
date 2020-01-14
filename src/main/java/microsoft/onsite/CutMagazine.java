package microsoft.onsite;

public class CutMagazine {
    //http://www.1point3acres.com/bbs/thread-375273-1-1.html

//    Cut a Magazine to get a note. A magazie is a single-line string (without '\n'),
//    and a note is a target string. Now using a sissor to cut the magazine,
//    we need to find the minimum cuts that are imposed on the magazine to get the note.
//    For example: Magazine="Hello World", Note="He Wor" -> 8 cuts。Magazine="Hello World",
//    Note="llo Wor" -> 4 cuts。

    static void minCut(String magazine, String note) {
        System.out.println(helper(magazine, note, 0, new boolean[magazine.length()]));
    }

    static int cut(String magazine, String note) {
        int cuts = helper(magazine, note, 0, new boolean[magazine.length()]);
        //if cuts is -1, not able to make note
        return cuts == -1 ? -1 : cuts * 4;
    }

    static int helper(String magazine, String note, int start, boolean[] visited) {
        //we donn't need do cut to get white space
        while (start < note.length() && note.charAt(start) == ' ') {
            start++;
        }

        //if reach the end of note, it means find one solution
        if (start == note.length()) {
            return 0;
        }

        int min = -1;

        // aaa b
        // aa b

        for (int j = 0; j < magazine.length(); j++) {

            int k = j;
            int i = start;

            //if the char at idx k of magazine isn't visited yet and it equals to the char
            //at index i of note, continue and find the longest path tha can be reach
            for (; i < note.length() && k < magazine.length(); i++) {
                if (visited[k] || magazine.charAt(k) != note.charAt(i)) {
                    break;
                }
                visited[k++] = true;
            }

            //if i is different from start, it means we find some math characters.
            //we can continue to try search remain part of note
            if (i != start) {
                int cut = helper(magazine, note, i, visited);
                if (cut >= 0) {
                    if (min == -1) {
                        min = cut + 1;
                    } else {
                        min = Math.min(min, cut + 1);
                    }
                }

                //Even we find one solution, we need recover those visited character
                //There maybe another better solution
                for (int l = j; l < k; l++) {
                    visited[l] = false;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        minCut("hello hello world hel", "hel ");
        minCut("you cando define api can", "cando yo api can");
        minCut("ab", "ba");
    }
}
