package airbnb;


import java.util.Stack;

public class Mini_Parser_385 {

    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) return null;

        if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-') {
            return new NestedInteger(Integer.parseInt(s));
        } else {
            NestedInteger list = new NestedInteger();
            helper(s, 1, list);
            return list;
        }
    }

    int helper(String s, int pos, NestedInteger list) {
        int pre = pos - 1;
        int i = pos;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ',') {
                if (i > pre + 1) {
                    list.add(new NestedInteger(Integer.parseInt(s.substring(pre + 1, i))));
                }
                pre = i;
            } else if (c == ']') {
                if (i > pre + 1) {
                    list.add(new NestedInteger(Integer.parseInt(s.substring(pre + 1, i))));
                }
                return i;
            } else if (c == '[') {
                NestedInteger next = new NestedInteger();
                list.add(next);
                i = helper(s, i + 1, next);
                pre = i;
            }
            i++;
        }
        return i;
    }


    public NestedInteger deserialize2(String s) {
        Stack<Object> stack = new Stack<>();
        int pre = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(c);
                pre = i;
            } else if (c == ',') {
                if (i > pre + 1) {
                    stack.push(new NestedInteger(Integer.parseInt(s.substring(pre + 1, i))));
                }
                pre = i;
            } else if (c == ']') {
                if (i > pre + 1) {
                    stack.push(new NestedInteger(Integer.parseInt(s.substring(pre + 1, i))));
                }
                pre = i;

                Stack<NestedInteger> temp = new Stack<>();
                while (stack.peek() instanceof NestedInteger) {
                    temp.push((NestedInteger)stack.pop());
                }
                stack.pop();

                NestedInteger nest = new NestedInteger();
                while (!temp.isEmpty()) {
                    nest.add(temp.pop());
                }
                stack.push(nest);

                if (stack.size() == 1)
                    return (NestedInteger) stack.pop();
            }
        }
        return new NestedInteger(Integer.parseInt(s));
    }

    public NestedInteger deserialize3(String s) {
        Stack<NestedInteger> stack = new Stack<>();

        NestedInteger cur = null;
        int pre = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
                pre = i;
            } else if (c == ',') {
                if (i > pre + 1) {
                    cur.add(new NestedInteger(Integer.parseInt(s.substring(pre + 1, i))));
                }
                pre = i;
            } else if (c == ']') {
                if (i > pre + 1) {
                    cur.add(new NestedInteger(Integer.parseInt(s.substring(pre + 1, i))));
                }
                pre = i;

                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(cur);
                    cur = pop;
                }
            }
        }

        return cur == null ? new NestedInteger(Integer.parseInt(s)) : cur;
    }

    public static void main(String[] args) {
        Mini_Parser_385 p = new Mini_Parser_385();
//        NestedInteger nest = p.deserialize3("[12,[[-34,[78]]],56]");
        NestedInteger nest = p.deserialize3("[12,[],[0]]");
        System.out.println(nest);

    }


}
