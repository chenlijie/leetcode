package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by chenlijie on 9/10/17.
 */
public class Minimum_Window_Substring_76 {

    public String minWindow3(String s, String t) {
        int[] map = new int[256];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int counter = t.length();
        int begin = 0;
        int end = 0;
        int d = Integer.MAX_VALUE;
        int head = 0;
        while(end < s.length()){
            if(map[s.charAt(end++)]-- > 0)
                counter--; //in t

            while(counter == 0){ //valid
                if(end-begin < d){
                    head = begin;
                    d = end - head;
                }

                if(map[s.charAt(begin++)]++ == 0)
                    counter++;  //make it invalid
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

    public String minWindow2(String s, String t) {
        int[] target = new int[256];
        int begin = 0;
        int end = Integer.MAX_VALUE;

        int count = t.length();
        for (int i = 0; i < count; i++) {
            target[t.charAt(i)]++;
        }

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (target[c]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (right - left < end - begin) {
                    end = right;
                    begin = left;
                }

                if (target[s.charAt(left)]++ == 0) {
                    count++;
                }
                left++;
            }
        }

        return end == 0 ? "" : s.substring(begin, end+1);
    }

    public static void main(String[] args) {
        System.out.println(new Minimum_Window_Substring_76().minWindow2("XADOBECODEBANC", "ABC"));
    }
}
