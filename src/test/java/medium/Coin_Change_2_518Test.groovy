package medium

import spock.lang.Specification

/**
 * Created by chenlijie on 3/21/17.
 */
class Coin_Change_2_518Test extends Specification {

    void 'test 1'() {
        expect:
        Coin_Change_2_518.change(7, [1,2,3,4,5,6,7,8,9,10] as int[]) == 6
    }
}
