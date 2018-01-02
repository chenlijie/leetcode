package complexity;

import java.util.Stack;

/**
 * Created by chenlijie on 12/21/17.
 */
public class StackOverflow {

    int goDeep(int n) {
        return n == 100000 ? 1 : goDeep(n+1);
    }

    public static void main(String[] args) {
        StackOverflow overflow = new StackOverflow();
        overflow.goDeep(0);
    }
}
