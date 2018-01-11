package medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chenlijie on 1/5/18.
 */
public class My_Calendar_I_729 {

    static class MyCalendar {

        private TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {
        }

        public boolean book(int start, int end) {

            Integer floor = map.floorKey(start);

            if (floor != null && map.get(floor) > start) return false;

            Integer ceiling = map.ceilingKey(start);

            if (ceiling != null && end > ceiling) return false;

            map.put(start, end);

            return true;
        }
    }
}
