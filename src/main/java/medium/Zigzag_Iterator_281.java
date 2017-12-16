package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 11/5/17.
 */
public class Zigzag_Iterator_281 {

    private List<List<Integer>> lists;
    private int rows;
    private int row;
    private int col;

    public Zigzag_Iterator_281(List<List<Integer>> lists) {
        this.lists = lists;
        rows = lists.size();
        row = 0;
        col = 0;
    }

    boolean hasNext() {
        int beforeChange = row;
        while (row < rows && (lists.get(row) == null || col >= lists.get(row).size())) {
            lists.remove(row);
            rows--;
            if (rows > 0) {
                row %= rows;
            }
            if (row == 0 && beforeChange != 0) {
                col++;
            }
        }

        return row < rows;
    }

    int next() {
        int val = lists.get(row).get(col);

        if (row + 1 == rows) {
            col++;
        }
        row = (row + 1)%rows;

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
        List<Integer> list6 = null;

        vector.add(list);
        vector.add(list0);
        vector.add(list1);
        vector.add(list2);
        vector.add(list3);
        vector.add(list4);
        vector.add(list5);
        vector.add(list6);

        Zigzag_Iterator_281 z = new Zigzag_Iterator_281(vector);

        while (z.hasNext()) {
            System.out.println(z.next());
        }
    }
}
