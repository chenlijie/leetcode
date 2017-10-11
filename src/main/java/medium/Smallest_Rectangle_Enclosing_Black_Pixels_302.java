package medium;

/**
 * Created by chenlijie on 9/6/17.
 */
public class Smallest_Rectangle_Enclosing_Black_Pixels_302 {

    public static int minArea(char[][] image, int x, int y) {

        int[] xArr = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] yArr = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        dfs(image, image.length, image[0].length, x, y, xArr, yArr);

        return (xArr[1]-xArr[0]+1)*(yArr[1]-yArr[0]+1);
    }

    private static void dfs(char[][] image, int xEnd, int yEnd, int x, int y, int[] xArr, int[] yArr) {

        if (x >= 0 && x < xEnd && y >= 0 && y < yEnd && image[x][y] == '1') {

            int[] dx = new int[] {-1, 1, 0, 0};
            int[] dy = new int[] {0, 0, -1, 1};

            if (y > 0)
                xArr[0] = Math.min(xArr[0], binarySearch(image, 0, y, true, true, x, y));
            if (y < yEnd)
                xArr[1] = Math.max(xArr[1], binarySearch(image, y, yEnd, true, false, x, y));

            if (x > 0)
                yArr[0] = Math.min(yArr[0], binarySearch(image, 0, x, false, true, x, y));
            if (x < xEnd)
                yArr[1] = Math.max(yArr[1], binarySearch(image, x, xEnd, false, false, x, y));

            image[x][y] = '0';

            for (int i = 0; i < 4; i++) {
                dfs(image, xEnd, yEnd,x+dx[i], y+dy[i], xArr, yArr);
            }
        }

    }

    private static int binarySearch(char[][] image, int lo, int hi, boolean flag, boolean flag2, int x, int y) {

        if (flag) {
            if (flag2) {
                while (lo < hi) {
                    int mi = (lo+hi)/2;

                    if (image[x][mi] == '0') {
                        lo = mi + 1;
                    } else {
                        hi = mi;
                    }
                }
            } else {
                while (lo < hi) {
                    int mi = (lo+hi)/2;

                    if (image[x][mi] == '1') {
                        lo = mi + 1;
                    } else {
                        hi = mi;
                    }
                }
            }

            return lo == image.length || image[x][lo] == '0' ? lo-1 : lo;
        } else {
            if (flag2) {
                while (lo < hi) {
                    int mi = (lo+hi)/2;

                    if (image[mi][y] == '0') {
                        lo = mi + 1;
                    } else {
                        hi = mi;
                    }
                }
            } else {
                while (lo < hi) {
                    int mi = (lo+hi)/2;

                    if (image[mi][y] == '1') {
                        lo = mi + 1;
                    } else {
                        hi = mi;
                    }
                }
            }

            return lo == image[0].length || image[lo][y] == '0' ? lo-1 : lo;
        }
    }

    public static void main(String[] args) {
        System.out.println(minArea(new char[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        }, 0, 2));
    }
}
