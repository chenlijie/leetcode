package hard;

import java.util.*;

/**
 * Created by chenlijie on 12/10/17.
 */
public class Insert_Delete_GetRandom_381 {

    static class RandomizedCollection {
        int lastIdx;
        List<Integer> nums;
        Map<Integer, LinkedHashSet<Integer>> locs;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            lastIdx = -1;
            nums = new ArrayList<>();
            locs = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean notContain = true;
            if (locs.containsKey(val))
                notContain = false;

            lastIdx++;
            nums.add(val);
            locs.putIfAbsent(val, new LinkedHashSet<>());
            locs.get(val).add(lastIdx);
            return notContain;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!locs.containsKey(val))
                return false;

            LinkedHashSet<Integer> idxOfVal = locs.get(val);
            int lastIdxOfVal = idxOfVal.iterator().next();

            int lastNum = nums.get(lastIdx);
            LinkedHashSet<Integer> idxOfLastNum = locs.get(lastNum);

            if (val == lastNum) {
                idxOfVal.remove(lastIdx);
                if (idxOfVal.isEmpty()) {
                    locs.remove(val);
                }
            } else {
                nums.set(lastIdxOfVal, lastNum);

                idxOfVal.remove(idxOfVal.iterator().next());
                if (idxOfVal.isEmpty()) {
                    locs.remove(val);
                }
                idxOfLastNum.remove(lastIdx);
                idxOfLastNum.add(lastIdxOfVal);
            }
            nums.remove(lastIdx);
            lastIdx--;
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            if (lastIdx < 0)
                return Integer.MIN_VALUE;

            Random random = new Random();
            int idx = random.nextInt(lastIdx + 1);
            return nums.get(idx);
        }

        /*int lastIdx;
        List<Integer> nums;
        Map<Integer, TreeSet<Integer>> locs;
        public RandomizedCollection() {
            lastIdx = -1;
            nums = new ArrayList<>();
            locs = new HashMap<>();
        }

        public boolean insert(int val) {
            boolean notContain = true;
            if (locs.containsKey(val))
                notContain = false;

            lastIdx++;
            if (nums.size() <= lastIdx) {
                nums.add(val);
            } else {
                nums.set(lastIdx, val);
            }
            locs.putIfAbsent(val, new TreeSet<>());
            locs.get(val).add(lastIdx);
            return notContain;
        }

        public boolean remove(int val) {
            if (!locs.containsKey(val))
                return false;

            TreeSet<Integer> idxOfVal = locs.get(val);
            int lastIdxOfVal = idxOfVal.last();

            int lastNum = nums.get(lastIdx);
            TreeSet<Integer> idxOfLastNum = locs.get(lastNum);
            int lastIdxOfLastNum = idxOfLastNum.last();

            if (val == lastNum) {
                idxOfVal.remove(idxOfVal.size() - 1);
                if (idxOfVal.isEmpty()) {
                    locs.remove(val);
                }
            } else {
                // nums.set(lastIdxOfLastNum, val);
                nums.set(lastIdxOfVal, lastNum);

                idxOfVal.pollLast();
                if (idxOfVal.isEmpty()) {
                    locs.remove(val);
                }
                idxOfLastNum.pollLast();
                idxOfLastNum.add(lastIdxOfVal);
            }

            lastIdx--;
            return true;
        }

        public int getRandom() {
            if (lastIdx < 0)
                return Integer.MIN_VALUE;

            Random random = new Random();
            int idx = random.nextInt(lastIdx + 1);
            return nums.get(idx);
        }*/
    }

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        obj.insert(10);
        obj.insert(10);
        obj.insert(20);
        obj.insert(20);
        obj.insert(30);
        obj.insert(30);

        obj.remove(10);
        obj.remove(10);
        obj.remove(30);
        obj.remove(30);

        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}
