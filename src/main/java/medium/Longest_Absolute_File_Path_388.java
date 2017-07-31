package medium;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Longest_Absolute_File_Path_388 {

    public int lengthLongestPath(String input) {
        path(input, "\\n", "");
        return max;
    }

    int max = 0;

    private void path(String input, String split, String s) {
        if (!input.contains(split)) {
            if (input.contains("\\.")) {
                max = Math.max(max, s.length() + input.length() + 1);
            }
        } else {
            String[] str = input.split(split);
            for (int i = 0; i < str.length; i++) {
                path(str[i], split + "\\t", s + "\\" + str[i]);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Longest_Absolute_File_Path_388().lengthLongestPath("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"));
//        System.out.println("dir\n\tsu".split("\\n\\t")[0]);
    }
}
