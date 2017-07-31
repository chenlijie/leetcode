package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlijie on 7/23/17.
 */
public class Gray_Code_89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for(int i=0;i<n;i++){
            int inc = 1<<i;
            for(int j=arr.size()-1;j>=0;j--){
                arr.add(arr.get(j)+inc);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(4));
    }
}
