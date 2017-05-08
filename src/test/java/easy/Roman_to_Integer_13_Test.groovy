package easy

import spock.lang.Specification

/**
 * Created by chenlijie on 4/14/17.
 */
class Roman_to_Integer_13_Test extends Specification {

    void 'test'() {
        expect:
        Roman_to_Integer_13.romanToInt("CXVI") == 116
        Roman_to_Integer_13.romanToInt("CXXVIII") == 128
        Roman_to_Integer_13.romanToInt("MMMMMVIII") == 5008
    }
}
