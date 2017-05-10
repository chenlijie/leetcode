package bit;

/**
 * Created by chenlijie on 5/8/17.
 */
public class BitManipulation {

    /**
     *
     *
     *
     * Set union A | B
     * Set intersection A & B
     * Set subtraction A & ~B
     * Set negation ALL_BITS ^ A or ~A
     * Set bit A |= 1 << bit
     * Clear bit A &= ~(1 << bit)
     * Test bit (A & 1 << bit) != 0
     * Extract last bit A&-A or A&~(A-1) or x^(x&(x-1))
     * Remove last bit A&(A-1)
     * Get all 1-bits ~0
     *
     *
     */

    public static void main(String[] args) {
        System.out.println(3 & ~1);//2
        System.out.println(4 & ~1);//3

        System.out.println(count_one(4));
        System.out.println(count_one(6));
        System.out.println(count_one(7));
        System.out.println(count_one(13));

        System.out.println(missingNumber(new int[]{0,1,2,4}) == 3);

        System.out.println(largest_power(9));

        System.out.println(~2+1);
        System.out.println(~3+1);
        System.out.println(~20+1);
        System.out.println(5+(~3+1));
    }

    static int count_one(int n) {
        int count = 0;
        while(n != 0) {
            n = n&(n-1);
            count++;
        }
        return count;
    }

    static int missingNumber(int[] nums) {
        int ret = 0;
        for(int i = 0; i < nums.length; ++i) {
            ret ^= i;
            ret ^= nums[i];
        }
        return ret^nums.length;
    }

    static long largest_power(long N) {
        //changing all right side bits to 1.
        N = N | (N>>1);
        N = N | (N>>2);
        N = N | (N>>4);
        N = N | (N>>8);
        N = N | (N>>16);
        return (N+1)>>1;
    }
}
