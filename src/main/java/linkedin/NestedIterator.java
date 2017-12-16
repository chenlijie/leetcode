package linkedin;

import java.util.*;

/**
 * Created by chenlijie on 12/10/17.
 */
public class NestedIterator implements Iterator<Integer> {

    /*Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushNestedListToStack(nestedList);
    }

    void pushNestedListToStack(List<NestedInteger> nestedList) {
        int last = nestedList.size() - 1;
        for (int i = last; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && stack.peek() instanceof List) {
            pushNestedListToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }*/
    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }

    private Stack<ListIterator<NestedInteger>> lists;

    public static void main(String[] args) {
//        NestedInteger i1 = new NestedInteger();
//        i1.obj = new Integer(1);
//
//        NestedInteger i2 = new NestedInteger();
//        List<NestedInteger> array = new ArrayList<>();
//        i2.obj = array;
//        array.add(i2);
//
//        List<NestedInteger> list = new ArrayList<>();
//        list.add(i2);
//        list.add(i1);
//
//        NestedIterator it = new NestedIterator(list);
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.remove(1);
        System.out.println(nums.size());
    }
}
