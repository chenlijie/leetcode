package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 7/30/17.
 */
public class Longest_Absolute_File_Path_388 {

    public int lengthLongestPath(String input) {
        int pre = -1;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        int total = 0;
        int len = input.length();

        while (i < len) {
            int cur = getLevel(input, i);
            int n = getSlashN(input, i);
            int fileLen = n - cur - i;

            if (cur > pre) {
                stack.push (fileLen);
            } else {
                while (pre-- >= cur) {
                    total -= stack.pop();
                }
                stack.push(fileLen);
            }
            total += fileLen;
            if (isFile(input, i, n)) {
                max = Math.max(max, total + cur);
            }
            pre = cur;
            i = n + 1;
        }

        return max;
    }

    int getLevel(String s, int i) {
        int cnt = 0;
        while (s.charAt(i) == '\t') {
            cnt++;
            i++;
        }
        return cnt;
    }

    int getSlashN(String s, int i) {
        int idx = s.indexOf('\n', i);
        return idx != -1 ? idx : s.length();
    }

    boolean isFile(String s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Longest_Absolute_File_Path_388 path = new Longest_Absolute_File_Path_388();
//        System.out.println(path.lengthLongestPath("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"));
        System.out.println(path.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

//        System.out.println((int)'\n');

//        System.out.println("\n".charAt(0) == '\n');
    }
}
