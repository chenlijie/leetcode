package easy;

/**
 * Created by chenlijie on 4/14/17.
 */
public class Roman_to_Integer_13 {

    /*
        I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1000
        IV
    */
    public static int romanToInt(String s) {

        char[] chars = s.toCharArray();
        int last = chars.length - 1;
        int sum = 0;
        int x = 0;

        for (int i = last; i >= 0; i--) {
            switch (chars[i]) {
                case 'I':
                    if (1 < x)
                        sum -= 1;
                    else
                        sum += 1;
                    x = 1;
                    break;
                case 'V':
                    if (5 < x)
                        sum -= 5;
                    else
                        sum += 5;
                    x = 5;
                    break;
                case 'X':
                    if (10 < x)
                        sum -= 10;
                    else
                        sum += 10;
                    x = 10;
                    break;
                case 'L':
                    if (50 < x)
                        sum -= 50;
                    else
                        sum += 50;
                    x = 50;
                    break;
                case 'C':
                    if (100 < x)
                        sum -= 100;
                    else
                        sum += 100;
                    x = 100;
                    break;
                case 'D':
                    if (500 < x)
                        sum -= 500;
                    else
                        sum += 500;
                    x = 500;
                    break;
                case 'M':
                    if (1000 < x)
                        sum -= 1000;
                    else
                        sum += 1000;
                    x = 1000;
                    break;
            }
        }
        return sum;
    }

}
