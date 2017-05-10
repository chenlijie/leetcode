package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator_341 implements Iterator<Integer> {

    private List<NestedInteger> list;
    private int size = 0;
    private int index = 0;

    public NestedIterator_341(List<NestedInteger> nestedList) {

        list = new ArrayList<>();
        Iterator<NestedInteger> iter = nestedList.iterator();

        while (iter.hasNext()) {
            NestedInteger next = iter.next();

            if (next.isInteger()) {
                list.add(next);
            } else {
                list.addAll(new NestedIterator_341(next.getList()).getList());
            }
        }

        size = list.size();

    }

    @Override
    public Integer next() {
        if (hasNext()) {
            index++;
            size--;
            return list.get(index).getInteger();
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean hasNext() {
        return size > 0;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}

 interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }

