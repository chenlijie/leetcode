package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenlijie on 11/4/17.
 */
public class Flatten_2D_Vector_251_Iterator {

    private List<List<Integer>> vector;
    private Iterator<List<Integer>> vecIt;
    private Iterator<Integer> valIt;

    public Flatten_2D_Vector_251_Iterator(List<List<Integer>> vector) {
        this.vector = vector;
        vecIt = this.vector.iterator();
        generateValIt();
    }

    void generateValIt() {
        while (vecIt.hasNext() && (valIt == null || !valIt.hasNext())) {
            List<Integer> vec = vecIt.next();
            valIt = vec != null ? vec.iterator() : null;
        }
    }

    boolean hasNext() {
        return valIt != null && valIt.hasNext();
    }

    int next() {
        int next = valIt.next();
        generateValIt();
        return next;
    }

    public static void main(String[] args) {
        List<List<Integer>> vector = new ArrayList<>();
        List<Integer> list = null;
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = null;
        List<Integer> list3 = Arrays.asList(3);
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = Arrays.asList(4, 5);
        List<Integer> list6 = null;

        vector.add(list);
        vector.add(list0);
        vector.add(list1);
        vector.add(list2);
        vector.add(list3);
        vector.add(list4);
        vector.add(list5);
        vector.add(list6);

        Flatten_2D_Vector_251_Iterator f = new Flatten_2D_Vector_251_Iterator(vector);

        while (f.hasNext()) {
            System.out.println(f.next());
        }

    }
}
