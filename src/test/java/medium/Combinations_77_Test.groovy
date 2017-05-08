package medium

import spock.lang.Specification

/**
 * Created by chenlijie on 4/15/17.
 */
class Combinations_77_Test extends Specification {

    void 'test'() {
        given:
        Combinations_77 test = new Combinations_77()

        when:
        List<List<Integer>> list = test.combine(4, 2)
        for (List<Integer> x : list) {
            System.out.println(x)
        }

        then:
        list.size() == 4
    }
}
