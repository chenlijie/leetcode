package hard

import spock.lang.Specification

/**
 * Created by chenlijie on 4/13/17.
 */
class Longest_Valid_Parentheses_32_Test extends Specification {

    void 'test'() {
        expect:
        Longest_Valid_Parentheses_32.longestValidParentheses("()))()()()") == 6
        Longest_Valid_Parentheses_32.longestValidParentheses(")))))))()") == 2
        Longest_Valid_Parentheses_32.longestValidParentheses(")))(())(((") == 4
    }

    void 'test2'() {
        expect:
        Longest_Valid_Parentheses_32.longestValidParentheses2("()))()()()") == 6
        Longest_Valid_Parentheses_32.longestValidParentheses2(")))))))()") == 2
        Longest_Valid_Parentheses_32.longestValidParentheses2(")))(())(((") == 4
    }

    void 'test3'() {
        expect:
        Longest_Valid_Parentheses_32.longestValidParentheses3("((())(") == 4
//        Longest_Valid_Parentheses_32.longestValidParentheses3("()))()()()") == 6
//        Longest_Valid_Parentheses_32.longestValidParentheses3(")))))))()") == 2
//        Longest_Valid_Parentheses_32.longestValidParentheses3(")))(())(((") == 4
    }
}
