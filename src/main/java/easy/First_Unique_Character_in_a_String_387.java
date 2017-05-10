package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlijie on 5/9/17.
 */
public class First_Unique_Character_in_a_String_387 {

    public static int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.putIfAbsent(chars[i], 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
