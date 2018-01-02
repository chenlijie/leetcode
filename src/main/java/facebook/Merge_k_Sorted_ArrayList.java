package facebook;

import java.util.*;

/**
 * Created by chenlijie on 12/17/17.
 */
public class Merge_k_Sorted_ArrayList {

    static List<Integer> mergeSortedArrayLists(List<List<Integer>> lists) {
        if (lists == null) {
            return new ArrayList<>();
        }

        /*PriorityQueue<ListIterator<Integer>> queue = new PriorityQueue<>(new Comparator<ListIterator<Integer>>() {
            @Override
            public int compare(ListIterator<Integer> o1, ListIterator<Integer> o2) {
                int x1 = o1.next();
                int x2 = o2.next();
                o1.previous();
                o2.previous();
                return x1 - x2;
            }
        });*/
        PriorityQueue<ListIterator<Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            int x1 = o1.next();
            int x2 = o2.next();
            o1.previous();
            o2.previous();
            return x1 - x2;
        });

        for (List<Integer> list : lists) {
            if (list != null && !list.isEmpty())
                queue.add(list.listIterator());
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            ListIterator<Integer> it = queue.poll();
            int val = it.next();
            if (it.hasNext()) {
                queue.offer(it);
            }
            ans.add(val);
        }
        return ans;
    }

    static List<Integer> mergeSortedArrayLists2(List<List<Integer>> lists) {
        if (lists == null) {
            return new ArrayList<>();
        }

        ListIterator[] its = new ListIterator[lists.size()];
        int size = 0;
        for (Iterator<List<Integer>> it = lists.iterator(); it.hasNext();) {
            List<Integer> list = it.next();
            if (list != null && !list.isEmpty()) {
                its[size++] = list.listIterator();
            }
        }

        for (int i = size/2 - 1; i >= 0; i--) {
            buildMinHeap(i, size, its);
        }

        List<Integer> ans = new ArrayList<>();
        while (size > 1) {
            ListIterator<Integer> it = its[0];
            ans.add(it.next());
            if (!it.hasNext()) {
                its[0] = its[size-1];
                size--;
            }
            buildMinHeap(0, size, its);
        }

        return ans;
    }

    static void buildMinHeap(int i, int size, ListIterator[] its) {
        int largest = i;

        if (2*i + 1 < size) {
            int left = (int)its[2*i + 1].next();
            int large = (int)its[largest].next();
            its[2*i + 1].previous();
            its[largest].previous();
            if (left < large) {
                largest = 2*i + 1;
            }
        }
        if (2*i + 2 < size) {
            int right = (int)its[2*i + 2].next();
            int large = (int)its[largest].next();
            its[2*i + 2].previous();
            its[largest].previous();
            if (right < large) {
                largest = 2*i + 2;
            }
        }

        if (largest != i) {
            swap(largest, i, its);
            buildMinHeap(largest, size, its);
        }
    }

    static void swap(int i, int j, ListIterator[] its) {
        ListIterator<Integer> t = its[i];
        its[i] = its[j];
        its[j] = t;
    }


    public static void main(String[] args) {
        System.out.println(mergeSortedArrayLists(null));
        System.out.println(mergeSortedArrayLists(new ArrayList<>()));

        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < 8; i+=3) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 2; i < 12; i+=3) {
            list2.add(i);
        }
        List<Integer> list3 = new ArrayList<>();
        for (int i = 3; i < 15; i+=3) {
            list3.add(i);
        }
        System.out.println("list1 " + list1);
        System.out.println("list2 " + list2);
        System.out.println("list3 " + list3);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
//        lists.add(new ArrayList<>());
//        lists.add(null);

        System.out.println(mergeSortedArrayLists2(lists));

        System.out.println("----------------------");
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list.add(i);
        }

        ListIterator<Integer> it = list.listIterator();
//        System.out.println(it.next());
//        System.out.println(it.previous());
//        System.out.println(it.next());
//        System.out.println(it.previous());
//        System.out.println(it.next());
    }
}
