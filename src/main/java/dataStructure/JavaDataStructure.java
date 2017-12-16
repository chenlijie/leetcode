package dataStructure;

import java.util.TreeSet;

/**
 * Created by chenlijie on 11/13/17.
 */
public class JavaDataStructure {

    static void testTreeSet() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(4);
        set.add(2);
        set.add(1);
        set.add(3);

        System.out.println(set.floor(3));
    }

    public static void main(String[] args) {
        testTreeSet();
    }
}
