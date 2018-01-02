package facebook;

import org.junit.Test;

import static facebook.Merge_k_Sorted_Arrays.mergeKSortedArrays;
import static org.junit.Assert.*;

/**
 * Created by chenlijie on 12/17/17.
 */
public class MergeKSortedArraysTest {


    @Test
    public void test_one_dimension_array() {
        MergeKSortedArrays merge = new MergeKSortedArrays(new int[][]{ {1,2,3} });
        int i = 1;

        while (merge.hasNext()) {
            assertEquals(i++, merge.next());
        }
    }

    @Test
    public void test_two_dimensions_array() {
        MergeKSortedArrays merge = new MergeKSortedArrays(new int[][]{ {1,3,6,7}, {2,4,5,8} });
        int i = 1;

        while (merge.hasNext()) {
            assertEquals(i++, merge.next());
        }
    }

    @Test
    public void test_multiple_dimensions_array() {
        MergeKSortedArrays merge = new MergeKSortedArrays(new int[][]{ {4,6,7,16}, {3,5,8,15}, {2,9,10,11}, {1,12,13,14} });
        int i = 1;

        while (merge.hasNext()) {
            assertEquals(i++, merge.next());
        }
    }
}