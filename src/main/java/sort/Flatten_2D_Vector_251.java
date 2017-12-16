package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 11/4/17.
 */
public class Flatten_2D_Vector_251 {

    private List<List<Integer>> vector;
    private int row;
    private int pos;

    public Flatten_2D_Vector_251(List<List<Integer>> vector) {
        this.vector = vector;
        row = 0;
        pos = 0;

        while (row < vector.size() && (vector.get(row) == null || vector.get(row).size() == 0)) {
            row++;
        }
    }

    boolean hasNext() {
        if (row < vector.size()) {
            return true;
        }

        return false;
    }

    int next() {
        if (row == vector.size()) {
            return -1;
        }

        int val = vector.get(row).get(pos++);

        if (pos == vector.get(row).size()) {
            row++;
            while (row < vector.size() && (vector.get(row) == null || vector.get(row).size() == 0)) {
                row++;
            }
            pos = 0;
        }

        return val;
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

        vector.add(list);
        vector.add(list0);
        vector.add(list1);
        vector.add(list2);
        vector.add(list3);
        vector.add(list4);
        vector.add(list5);

        Flatten_2D_Vector_251 f = new Flatten_2D_Vector_251(vector);

        while (f.hasNext()) {
            System.out.println(f.next());
        }

        System.out.println(f.next());
    }
}
