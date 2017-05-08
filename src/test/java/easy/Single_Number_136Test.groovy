package easy

import spock.lang.Specification

class Single_Number_136Test extends Specification {

    void 'test'() {
        expect:
        Single_Number_136.singleNumber([1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,8,9,10,11,12,13] as int[]) == 7
        1 << 2 == 4
        if(1^0) {
            println(1)
        }
    }
}
