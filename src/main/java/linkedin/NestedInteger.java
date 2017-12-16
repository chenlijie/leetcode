package linkedin;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    Object obj;
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
      return obj instanceof Integer;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
      return (Integer)obj;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
      return (List<NestedInteger>)obj;
    }

    public static void main(String[] args) {
        NestedInteger i1 = new NestedInteger();
        i1.obj = new Integer(1);

        List<Integer> array = new ArrayList<>();
        array.add(2);

        NestedInteger i2 = new NestedInteger();
        i2.obj = array;
    }
}
