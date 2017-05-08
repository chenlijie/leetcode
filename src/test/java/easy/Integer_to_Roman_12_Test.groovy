package easy

import spock.lang.Specification

/**
 * Created by chenlijie on 4/14/17.
 */
class Integer_to_Roman_12_Test extends Specification {

    void 'test'() {
        expect:
        Integer_to_Roman_12.intToRoman(116) == "CXVI"
        Integer_to_Roman_12.intToRoman(128) == "CXXVIII"
        Integer_to_Roman_12.intToRoman(5008) == "MMMMMVIII"
        Integer_to_Roman_12.intToRoman(40) == "XL"
    }
}
