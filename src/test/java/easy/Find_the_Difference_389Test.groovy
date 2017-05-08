package easy

import spock.lang.Specification

class Find_the_Difference_389Test extends Specification {

    void 'test 1'() {
        expect:
        Find_the_Difference_389.findTheDifference('abcdefg','acefgbdx') == 'x'
    }

    void 'test 2'() {
        expect:
        Find_the_Difference_389.findTheDifference2('abcdefg','acefgbdx') == 'x'
    }
}
