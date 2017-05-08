package medium

import spock.lang.Specification

/**
 * Created by chenlijie on 3/24/17.
 */
class Single_Number_II_137Test extends Specification {

    void 'test'() {
        expect:
        Single_Number_II_137.singleNumber([2,2,3,2] as int[]) == 3
    }

    void 'test2'() {
        expect:
        Single_Number_II_137.singleNumber2([1,2,4,1,4,1,2,3,4,2] as int[]) == 3
    }
}
