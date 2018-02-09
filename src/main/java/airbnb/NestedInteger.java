package airbnb;


import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    int value;
    List<NestedInteger> list;

    public NestedInteger() {
        list = new ArrayList<>();
    }

    public NestedInteger(int value) {
        this.value = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return list == null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return value;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.value = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public String toString() {
        if (list == null) {
            return value + "";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    builder.append(list.get(i).toString());
                } else {
                    builder.append(list.get(i).toString()).append(",");
                }
            }
            builder.append("]");
            return builder.toString();
        }
    }
}
