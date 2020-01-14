package microsoft.onsite;

import utility.Utils;

public class DoubelWhiteSpace {

    //给定字符串里面的空格重复一下
    static void doubleWitheSpace(char[] c) {
        int len = c.length;
        int start = 0;
        int end = 0;

        for (int i = 0; i < len; i++) {
            if (Character.isLetter(c[i])) {
                start = i;
                break;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (Character.isLetter(c[i])) {
                end = i;
                break;
            }
        }

        int j = len - 1;
        for (int i = end; i >= start; i--) {
            if (Character.isLetter(c[i])) {
                c[j] = c[i];
            } else {
                c[j--] = ' ';
                c[j] = ' ';
            }
            j--;
        }

        int i = 0;
        for (int k = j + 1; k < len; k++) {
            c[i++] = c[k];
        }

        while (i < len) {
            c[i++] = '\u0000';
        }

        for (char x : c) {
            System.out.print(x);
        }
    }

    public static void main(String[] args) {
        char[] c = new char[20];

        c[2] = 'b';
        c[3] = 'c';
        c[5] = ' ';
        c[6] = 'd';
        c[7] = ' ';
        c[8] = ' ';
        c[9] = 'e';



        doubleWitheSpace(c);
    }
}
