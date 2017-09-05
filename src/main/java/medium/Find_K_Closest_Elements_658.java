package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenlijie on 9/3/17.
 */
public class Find_K_Closest_Elements_658 {

    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

        int lo = 0;
        int hi = arr.size();
        int mi = 0;

        while (lo < hi) {

            mi = (lo+hi)>>1;

            if (arr.get(mi) > x && (mi - lo) > k) {
                hi = mi;
            } else if (arr.get(mi) < x && (hi - mi) > k) {
                lo = mi + 1;
            } else {
                break;
            }
        }

        List<Integer> closest = new ArrayList<>();

        for (int i = Math.max(0,mi-k); i < mi+k && closest.size() < k; i++) {
            closest.add(arr.get(i));
        }

        int i = Math.max(0, mi-k);
        int j = i + k;

        while (j < arr.size()) {
            if (Math.abs(arr.get(j) - x) < Math.abs(arr.get(i) - x)) {
                closest.remove(0);
                closest.add(arr.get(j));
                i++;
                j++;
            } else {
                break;
            }
        }

        i--;
        j--;
        while (i > 0) {
            if (Math.abs(arr.get(j) - x) >= Math.abs(arr.get(i) - x)){
                closest.remove(k-1);
                closest.add(0, arr.get(i));
                i--;
                j--;
            } else {
                break;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(0,0,1,2,3,3,4,7,7,8);
        List<Integer> list = Arrays.asList(0,0,0,1,3,5,6,7,8,8);
        for (int i : findClosestElements(list, 2, 2)) {
            System.out.print(i + "  ");
        }

    }
}
