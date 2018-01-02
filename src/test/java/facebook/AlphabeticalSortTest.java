package facebook;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenlijie on 12/17/17.
 */
public class AlphabeticalSortTest {

    AlphabeticalSort sort = new AlphabeticalSort();
    List<String> words;
    String order = "cdfag";

    @Before
    public void setup() {
        words = new ArrayList<>();
        words.add("df");
        words.add("ag");
        words.add("cg");
    }

    @Test
    public void sort_1() throws Exception {
        List<String> ans = sort.sort(words, order);
        List<String> expect = new ArrayList<>();
        expect.add("cg");
        expect.add("df");
        expect.add("ag");

        assertEquals(ans.get(0), expect.get(0));
        assertEquals(ans.get(1), expect.get(1));
        assertEquals(ans.get(2), expect.get(2));
    }

    @Test
    public void sort_2() {
        order = "zyxwvutsrqponmlkjihgfedcba";
        words.clear();
        words.add("banana");
        words.add("pear");
        words.add("blackberry");
        words.add("strawberry");
        words.add("apple");
        words.add("kiwi");
        words.add("mango");
        words.add("z");

        sort.sort(words, order);
    }
}