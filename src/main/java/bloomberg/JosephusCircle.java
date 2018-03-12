package bloomberg;

import java.util.ArrayList;
import java.util.List;

public class JosephusCircle {

    //约瑟夫环
    static int getAnswer(int n, int m) {
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(i);
        }

        int last = n;
        while (last > 1) {
            int idx = m % last == 0 ? last : m % last;
            arr.remove(idx);
            last--;
        }
        System.out.println("last one is " + arr.get(1));
//        return Integer.parseInt(arr.get(1));
        return arr.get(1);
    }

    public static void main(String[] args) {
        getAnswer(3, 3);
    }
}
