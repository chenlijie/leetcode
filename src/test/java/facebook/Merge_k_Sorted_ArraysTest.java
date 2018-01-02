package facebook;

import org.junit.Test;

import static org.junit.Assert.*;
import static facebook.Merge_k_Sorted_Arrays.mergeKSortedArrays;

/**
 * Created by chenlijie on 12/17/17.
 */
public class Merge_k_Sorted_ArraysTest {

    @Test
    public void test_empty_arrays() {
        assertTrue(mergeKSortedArrays(new int[0][0]).length == 0);
    }

    @Test
    public void test_one_dimension_array() {
        int[] res = mergeKSortedArrays(new int[][]{ {1,2,3} });
        assertTrue(res.length == 3);
        for (int i = 0; i < 3; i++) {
            assertEquals(res[i], i+1);
        }
    }

    @Test
    public void test_two_dimensions_array() {
        int[] res = mergeKSortedArrays(new int[][]{ {1,3,6,7}, {2,4,5,8} });
        assertTrue(res.length == 8);
        for (int i = 0; i < 8; i++) {
            assertEquals(res[i], i+1);
        }
    }

    @Test
    public void test_multiple_dimensions_array() {
        int[] res = mergeKSortedArrays(new int[][]{ {4,6,7,16}, {3,5,8,15}, {2,9,10,11}, {1,12,13,14} });
        assertTrue(res.length == 16);
        for (int i = 0; i < 16; i++) {
            System.out.print(res[i] + " ");
            assertEquals(res[i], i+1);
        }
    }
}