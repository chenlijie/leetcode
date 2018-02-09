package airbnb;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Flatten_2D_Vector_251 {

    Iterator<List<Integer>> rowIt;
    Iterator<Integer> colIt;

    public Flatten_2D_Vector_251(List<List<Integer>> vec2d) {
        if (vec2d != null)
            rowIt = vec2d.iterator();
    }

    public Integer next() {
        return colIt.next();
    }

    public boolean hasNext() {
        while ((colIt == null || !colIt.hasNext()) && rowIt != null && rowIt.hasNext()) {
            List<Integer> next = rowIt.next();
            if (next != null)
                colIt = next.iterator();
        }
        return colIt != null && colIt.hasNext();
    }

    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(Arrays.asList(1,2));
        vec2d.add(new ArrayList<>());
        vec2d.add(null);
        vec2d.add(Arrays.asList(3,4));
        vec2d.add(new ArrayList<>());
        vec2d.add(null);

        Flatten_2D_Vector_251 v = new Flatten_2D_Vector_251(null);

        while (v.hasNext()) {
            System.out.println(v.next());
        }

        char[] c = new char[] {'a', 'b', 'c', 'd', 'e'};

        System.out.println(new String(c, 5, 0));
    }
}
