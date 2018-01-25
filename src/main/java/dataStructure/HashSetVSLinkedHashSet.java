package dataStructure;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetVSLinkedHashSet {


    public static void main(String[] args) {
        testLinkedHashSet();
        testHashSet();
    }


    static void testHashSet() {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<=1000000; i++)
            set.add(i);
        for (int i=0; i<1000000; i++)
            set.remove(i);

        long t0 = System.currentTimeMillis();
        for (int i=0; i<10000; i++)
            set.iterator().next();
        System.out.println(System.currentTimeMillis() - t0);
    }

    static void testLinkedHashSet() {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i=0; i<=1000000; i++)
            set.add(i);
        for (int i=0; i<1000000; i++)
            set.remove(i);

        long t0 = System.currentTimeMillis();
        for (int i=0; i<10000; i++)
            set.iterator().next();
        System.out.println(System.currentTimeMillis() - t0);
    }
}
