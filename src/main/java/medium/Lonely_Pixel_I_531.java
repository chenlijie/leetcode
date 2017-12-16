package medium;

/**
 * Created by chenlijie on 11/15/17.
 */
public class Lonely_Pixel_I_531 {


    // X = 1 B
    // Y = more than 1 B
    static int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }

        int m = picture.length;
        int n = picture[0].length;

        char row = 'W';
        char col = 'W';


        for (int i = 0; i < m; i++) {
            if (picture[i][0] == 'B') {
                if (col == 'W') {
                    col = 'X';
                } else if (col == 'X') {
                    col = 'Y';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (picture[0][i] == 'B') {
                if (row == 'W') {
                    row = 'X';
                } else if (row == 'X') {
                    row = 'Y';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    if (picture[0][j] != 'Y') {
                        picture[0][j] = 'X';
                    } else if (picture[0][j] == 'X') {
                        picture[0][j] = 'Y';
                    }

                    if (picture[i][0] != 'Y') {
                        picture[i][0] = 'X';
                    } else if (picture[i][0] == 'X') {
                        picture[i][0] = 'Y';
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (picture[i][j] == 'B' && picture[0][j] == 'X' && picture[i][0] == 'X') {
                    cnt++;
                }
            }
        }

        if (row == 'X') {
            for (int i = 1; i < n; i++) {
                if (picture[0][i] == 'X') {
                    cnt++;
                }
            }
        }

        if (col == 'X') {
            for (int i = 1; i < m; i++) {
                if (picture[i][0] == 'X') {
                    cnt++;
                }
            }
        }

        if (row == 'X' && col == 'X') {
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][] {
                {'B', 'W', 'W'},
                {'W', 'B', 'W'},
                {'W', 'W', 'B'}
        };

        System.out.println(findLonelyPixel(chars));
    }
}
