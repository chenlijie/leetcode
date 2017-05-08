package easy;

/**
 * Created by chenlijie on 4/26/17.
 */
public class Two_Sum_II_167 {

    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int h = numbers.length-1;
        int[] res = new int[2];
        while(l < h) {
            if (numbers[l]+numbers[h] == target) {
                res[0] = l+1;
                res[1] = h+1;
                break;
            }
            if (numbers[l]+numbers[h] > target) h--;
            if (numbers[l]+numbers[h] < target) l++;
        }

        return res;
    }
}
