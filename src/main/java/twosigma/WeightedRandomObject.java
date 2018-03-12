package twosigma;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeightedRandomObject<T> {

//    然后让设计一个数据结构用来存字符串和其相对应的weight。实现两个function.
//      1. put(string, weight)
//      2. string fetch()
//    其中fetch基于weight随机返回其中一个字符串，比方说2个字符串，如果weight相同，那么fetch应该有50%的机会返回其中任意一个。如果一个的weight是2，另一个的weight是1，那么返回第一个字符串的机率应该是第二个的2倍。fetch的使用频率远高于put。
//
    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=321498&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D34%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    private double total;
    private Map<T, Double> weight;
    private Random rand;

    public WeightedRandomObject() {
        total = 0;
        weight = new HashMap<>();
        rand = new Random();
    }

    public void put(T obj, Double w) {
        // maintain total
        if (weight.containsKey(obj)) {
                total -= weight.get(obj);
        }
        total += w;

        weight.put(obj, w);
    }

    public T get() {
        T res = null;

        Double cur = rand.nextDouble() * total;

        for (Map.Entry<T, Double> entry : weight.entrySet()) {
            cur -= entry.getValue();
            if (cur.compareTo(0.0) <= 0) {
                res = entry.getKey();
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        WeightedRandomObject<Integer> w = new WeightedRandomObject();
        w.put(1, 3.0);
        w.put(2, 2.0);
        w.put(3, 1.0);
        System.out.println(w.get());
        System.out.println(w.get());
        System.out.println(w.get());

    }
}
