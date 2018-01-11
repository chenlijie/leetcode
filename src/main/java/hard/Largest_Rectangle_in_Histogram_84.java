package hard;

import java.util.Stack;

/**
 * Created by chenlijie on 1/3/18.
 */
public class Largest_Rectangle_in_Histogram_84 {

    static int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;

        int max = 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < len) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int j = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, w * heights[j]);
            }
        }

        while (!stack.isEmpty()) {
            int tp = stack.pop();
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, w * heights[tp]);
        }

        return max;
    }

    static int largestRectangleArea2(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static int getMaxArea(int hist[], int n)
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    static int largestRectangleArea4(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        System.out.println(largestRectangleArea(new int[] {1,3,2}));
        System.out.println(largestRectangleArea4(new int[] {1,2,3}));
//        System.out.println(largestRectangleArea(new int[] {5,4,1,2}));
//        System.out.println(largestRectangleArea2(new int[] {2,1,2}));
//        System.out.println(getMaxArea(new int[] {2,1,2}, 3));
    }
}
