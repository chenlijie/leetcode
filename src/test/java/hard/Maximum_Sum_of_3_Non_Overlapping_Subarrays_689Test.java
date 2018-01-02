package hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenlijie on 12/17/17.
 */
public class Maximum_Sum_of_3_Non_Overlapping_Subarrays_689Test {

    @Test
    public void test() throws Exception {
        Maximum_Sum_of_3_Non_Overlapping_Subarrays_689 t = new Maximum_Sum_of_3_Non_Overlapping_Subarrays_689();
        int[] ans = t.maxSumOfThreeSubarrays(new int[] {7,13,20,19,19,2,10,1,1,19}, 3);
        assertTrue(ans[0] == 1 && ans[1] == 4 && ans[2] == 7);
    }

}