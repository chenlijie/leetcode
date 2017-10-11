package bit;

import utility.Utils;

/**
 * Created by chenlijie on 9/26/17.
 */
public class NextNumber {

    public static int[] nextNum(int num) {
        int[] result = new int[2];

        boolean findOne = false;
        boolean findZero = false;

        int one = 0;
        int zero = 0;

        for (int i = 0; i < 32; i++) {

            if (!findOne && (num & (1 << i)) != 0) {
                findOne = true;
                one = i;
            }

            if (findOne && (num & (1 << i)) == 0) {
                findZero = true;
                zero = i;
                break;
            }
        }

        if (findZero) {
            result[1] = num & (~(1 << one)) | (1 << zero);
        } else {
            result[1] = num;
        }

        findOne = false;
        findZero = false;

        for (int i = 0; i < 32; i++) {

            if (!findZero && (num & (1 << i)) == 0) {
                findZero = true;
                zero = i;
            }

            if (findZero && (num & (1 << i)) == 0) {
                zero = i;
            }

            if (findZero && (num & (1 << i)) != 0) {
                findOne = true;
                one = i;
                break;
            }
        }

        if (findOne) {
            result[0] = num & (~(1 << one)) | (1 << zero);
        } else {
            result[0] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        Utils.printArray(nextNum(11));

        System.out.println((~0));

        System.out.println((-1)>>>1);
    }
}
