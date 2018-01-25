package search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenlijie on 1/11/18.
 */
public class BinarySearchRotatedArrayTest {
    @Test
    public void getIdxOfMin() throws Exception {
        assertTrue(BinarySearchRotatedArray.getIdxOfMin(new int[]{0,1,2,3}) == 0);
        assertTrue(BinarySearchRotatedArray.getIdxOfMin(new int[]{4,5,6,0,1,2,3}) == 3);
        assertTrue(BinarySearchRotatedArray.getIdxOfMin(new int[]{0}) == 0);
        assertTrue(BinarySearchRotatedArray.getIdxOfMin(new int[]{1,0}) == 1);
        assertTrue(BinarySearchRotatedArray.getIdxOfMin(new int[]{1,1,1,1,0,0,0}) == 4);
    }

}