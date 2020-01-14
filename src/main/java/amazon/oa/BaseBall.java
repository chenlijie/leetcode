package amazon.oa;

import java.util.Stack;

public class BaseBall {

    static int getScore(String[] str) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

//        丢棒球，输入一个字符串，其中包括整数，Z，X，或者+。
//        整数代表此轮得分，
//        X：当前成绩是 double 前面一个分数，
//        +：当前成绩是前两个的和，
//        Z：移除前一个成绩，求最后的总成绩和

        for (int i = 0; i < str.length; i++) {
            if ("X".equals(str[i])) {
                stack.push(2 * stack.peek());
                sum += stack.peek();
            } else if ("+".equals(str[i])) {
                int p = stack.pop();
                int previousTwo = p + stack.peek();
                stack.push(p);
                stack.push(previousTwo);
                sum += previousTwo;
            } else if ("Z".equals(str[i])) {
                sum -= stack.pop();
            } else {
                stack.push(Integer.parseInt(str[i]));
                sum += stack.peek();
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        getScore(new String[]{"5", "-2", "4", "Z","X", "9", "+","+"});
    }
}
