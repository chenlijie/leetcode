package amazon.oa;

import java.util.ArrayList;
import java.util.List;

public class Utilization {
    
    public static List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList, List<List<Integer>> backgroundAppList) {

        int gap = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < foregroundAppList.size(); i++) {

            int k = deviceCapacity - foregroundAppList.get(i).get(1);

            int lo = 0;
            int hi = backgroundAppList.size();

            while (lo < hi) {
                int mi = (lo + hi) / 2;

                if (k < backgroundAppList.get(mi).get(1)) {
                    hi = mi;
                } else {
                    lo = mi + 1;
                }
            }

            if (lo == backgroundAppList.size()) {
                if (gap > k - backgroundAppList.get(lo - 1).get(1)) {
                    gap = k - backgroundAppList.get(lo - 1).get(1);
                    List<Integer> list = new ArrayList<>(2);
                    list.add(foregroundAppList.get(i).get(1));
                    list.add(backgroundAppList.get(lo - 1).get(1));
                    ans.clear();
                    ans.add(list);
                } if (gap == k - backgroundAppList.get(lo - 1).get(1)) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(foregroundAppList.get(i).get(1));
                    list.add(backgroundAppList.get(lo - 1).get(1));
                    ans.add(list);
                }
            } else if (backgroundAppList.get(lo).get(1) <= k) {
                if (gap > k - backgroundAppList.get(lo).get(1)) {
                    gap = k - backgroundAppList.get(lo).get(1);
                    List<Integer> list = new ArrayList<>(2);
                    list.add(foregroundAppList.get(i).get(1));
                    list.add(backgroundAppList.get(lo).get(1));
                    ans.clear();
                    ans.add(list);
                } if (gap == k - backgroundAppList.get(lo).get(1)) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(foregroundAppList.get(i).get(1));
                    list.add(backgroundAppList.get(lo).get(1));
                    ans.add(list);
                }
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> foregroundAppList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(8);
        foregroundAppList.add(list);
        list = new ArrayList<>();
        list.add(2);list.add(7);
        foregroundAppList.add(list);
        list = new ArrayList<>();
        list.add(3);list.add(14);
        foregroundAppList.add(list);

        List<List<Integer>> backgroundAppList = new ArrayList<>();
        list = new ArrayList<>();
        list.add(1);list.add(5);
        backgroundAppList.add(list);
        list = new ArrayList<>();
        list.add(2);list.add(10);
        backgroundAppList.add(list);
        list = new ArrayList<>();
        list.add(3);list.add(14);
        backgroundAppList.add(list);

        optimalUtilization(20, foregroundAppList, backgroundAppList);
    }
}
