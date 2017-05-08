package easy

import spock.lang.Specification

/**
 * Created by chenlijie on 4/11/17.
 */
class Valid_Parentheses_20_Test extends Specification {

    void 'test'() {
        expect:
        Valid_Parentheses_20.isValid("{}[]{}(){}()[]{}()") == true
        Valid_Parentheses_20.isValid("{}[]{}(){}()[]{}({})") == true
        Valid_Parentheses_20.isValid("([])") == true
        Valid_Parentheses_20.isValid("((") == false
        Valid_Parentheses_20.isValid("[[[[[]]]][") == false
    }

    void 'test2'() {
        expect:
        Valid_Parentheses_20.isValid_2("{}[]{}(){}()[]{}()") == true
        Valid_Parentheses_20.isValid_2("{}[]{}(){}()[]{}({})") == true
        Valid_Parentheses_20.isValid_2("([])") == true
        Valid_Parentheses_20.isValid_2("((") == false
        Valid_Parentheses_20.isValid_2("[[[[[]]]][") == false
    }
}
