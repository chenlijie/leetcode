package easy;

/**
 * Created by chenlijie on 7/31/17.
 */
public class Can_Place_Flowers_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;
        int can = 0;
        for (int i = 0; i < len;) {

            if (i == 0 && flowerbed[i] == 0 && (len == 1 || (i+1) < len && flowerbed[i+1] == 0)) {
                i += 2;
                can++;
            } else if (i == len-1 && flowerbed[i] == 0 && (len == 1 || (i-1) >= 0 && flowerbed[i-1] == 0)) {
                i++;
                can++;
            } else if ((i-1) > 0 && flowerbed[i] == 0 && (i+1) < len && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                i += 2;
                can++;
            } else {
                i++;
            }

            if (can >= n) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Can_Place_Flowers_605().canPlaceFlowers(new int[]{0,1,0}, 1));
    }
}
