package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenlijie on 8/2/17.
 */
public class Repeated_DNA_Sequences_187 {


    public static List<String> findRepeatedDnaSequences(String s) {

        if(s.length() < 11) {
            return new ArrayList<>();
        }

        Set<String> list = new HashSet<>();
        for (int i = 0; i < s.length()-10; i++) {
            String target = s.substring(i, i+10);

            for (int j = i+1; j <= s.length()-10; j++) {
                if (target.equals(s.substring(j, j+10))) {
                    list.add(target);
                    break;
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }
}
