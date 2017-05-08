package medium;

import java.util.Stack;

/**
 * Created by chenlijie on 5/3/17.
 */
public class Simplify_Path_71 {

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        for (String str : path.split("/")) {
            if ("".equals(str)) continue;

            switch (str) {
                case "." :
                    break;
                case "..":
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push("/" + str);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/").equals("/"));
        System.out.println(simplifyPath("/a").equals("/a"));
        System.out.println(simplifyPath("/a/b/").equals("/a/b"));
        System.out.println(simplifyPath("/a/b/././././").equals("/a/b"));
        System.out.println(simplifyPath("/a/b/./../././").equals("/a"));
        System.out.println(simplifyPath("/a/../b").equals("/b"));
    }
}
