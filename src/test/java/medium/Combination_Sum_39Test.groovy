package medium

import spock.lang.Specification

/**
 * Created by chenlijie on 4/15/17.
 */
class Combination_Sum_39Test extends Specification {

    void 'test'() {
        given:
        int[] array = new int[4]
        array[0] = 2
        array[1] = 3
        array[2] = 6
        array[3] = 7

        expect:
        Combination_Sum_39.combinationSum(array, 7) == [[7], [2, 2, 3]]
    }
}