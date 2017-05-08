package easy

import spock.lang.Specification

class Keyboard_Row_500Test extends Specification {

    void 'test 1'() {

        expect:
        Keyboard_Row_500.findWords(["Hello", "Alaska", "Dad", "Peace"] as String[]) == ["Alaska", "Dad"] as String[]

        Keyboard_Row_500.findWords(["a", "V", "W"] as String[]) == ["a", "V", "W"] as String[]
    }
}
