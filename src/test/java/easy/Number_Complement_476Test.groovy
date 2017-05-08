package easy

import spock.lang.Specification

class Number_Complement_476Test extends Specification {

    void 'test 1'() {
        expect:
        Number_Complement_476.findComplement(5) == 2
        Number_Complement_476.findComplement(1) == 0
        Number_Complement_476.findComplement(2) == 1
    }

    void 'test 2'() {
        expect:
        Number_Complement_476.findComplement_2(5) == 2
        Number_Complement_476.findComplement_2(1) == 0
        Number_Complement_476.findComplement_2(2) == 1
    }

    void 'test 3'() {
        expect:
        Integer.highestOneBit(16) == 3
    }
}
