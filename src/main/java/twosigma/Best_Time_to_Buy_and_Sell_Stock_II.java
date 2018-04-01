package twosigma;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int lastBuy = Integer.MAX_VALUE;
        int lastSell = 0;

        for (int i = 0; i < prices.length; i++) {
            //price is less than lastBuy price, update lastBuy
            if (prices[i] <= lastBuy) {
                lastBuy = prices[i];
                lastSell = 0;
            } else {
                //lastSell is 0 thta means it is first time to sell after last buy
                if (lastSell == 0) {
                    profit += prices[i] - lastBuy;
                } else {
                    //sell at this price can get more profit than lastSell price
                    //the profit gap is prices[i] - lastSell
                    //if sell at lastSell price, profit is lastSell - lastBuy
                    //if sell at this price, profit is price - lastBuy = price - lastSell + lastSell - lastBuy
                    profit += prices[i] - lastSell;
                }
                lastSell = prices[i];
                lastBuy = prices[i];
            }
        }

        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        int len = prices.length;

        int i = 0;
        while (i < len) {
            //find min buy price
            int buy = prices[i];
            while (i + 1 < len && prices[i + 1] <= buy) {
                buy = prices[++i];
            }


            //find max sell price
            int sell = prices[i];
            while (i + 1 < len && prices[i + 1] >= sell) {
                sell = prices[++i];
            }

            profit += sell - buy;
            i++;
        }

        return profit;
    }

    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "a");
//        map.put(2, "b");
//        map.put(1, "c");
//        map.get(2);

        new Best_Time_to_Buy_and_Sell_Stock_II().test();
    }

    void test() {
        Person p1 = new Person("jimmy", 33);
        Person p2 = new Person("jimmy", 32);
        Person p3 = new Person("freja", 30);
        Map<Person, String> map = new HashMap<>();
        map.put(p1, "a");
        map.put(p2, "b");
        map.put(p3, "c");
        map.keySet();
        map.get(p1);
        map.get(p2);
        map.get(p3);
        map.entrySet();
        map.remove(p1);

        System.out.println(map.get(p1));
        p1.age = 100;

    }

//    static int[] getMinimumUniqueSum(String[] arr) {
//        int len = arr.length;
//        int[] ans = new int[len];
//
//        for (int i = 0; i < len; i++) {
//            ans[i] = getSquares(arr[i]);
//        }
//        return ans;
//    }

    static int getSquares(String str) {
        String[] s = str.split(" ");
        int start = Integer.valueOf(s[0]);
        int end = Integer.valueOf(s[1]);

        int total = 0;
        for (int i = start; i <= end; i++) {
            if (Math.pow((int)Math.sqrt(i), 2) == i)
                total++;
        }
        return total;
    }


    class Person implements Comparable<Person> {
        String name;

        @Override
        public int compareTo(Person o) {
            return name.compareTo(o.name) == 0 ? age - o.age : name.compareTo(o.name);
        }

        int age;

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append(", hash=").append(hashCode());
            sb.append('}');
            return sb.toString();
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, age);
        }
    }
}
