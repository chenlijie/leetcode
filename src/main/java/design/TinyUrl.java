package design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

/**
 * Created by chenlijie on 12/27/17.
 */
public class TinyUrl {

    char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    Map<String, String> db = new HashMap<>();
    Map<Long, String> db2 = new HashMap<>();
    long id = 1918283746;

//    long id = 1;
    String getShortUrl(String longUrl) {
        char[] url = new char[6];
        int i = 5;
        long num = id;

        while (num > 0) {
            url[i] = map[(int)(num % 62)];
            num = num / 62;
            i--;
        }
        String shortUrl = new String(url);
        db.put(shortUrl, longUrl);
        db2.put(id, longUrl);

        return shortUrl;
    }


    String getLongUrl(String shortUrl) {
        long num = 0;

        for (int i = 5; i >= 0;i --) {
            char c = shortUrl.charAt(i);

            if (Character.isLowerCase(c)) {
                num += Math.pow(62, 5-i) * (c - 'a');
            } else if (Character.isUpperCase(c)) {
                num += Math.pow(62, 5-i) * (c - 'A' + 26);
            } else if (Character.isDigit(c)) {
                num += Math.pow(62, 5-i) * (c - '0' + 52);
            }
        }

        return db2.get(num);
    }

    public static void main(String[] args) {
        TinyUrl tiny = new TinyUrl();
        String long1 = "jimmy";
        String short1 = tiny.getShortUrl(long1);
        System.out.println(short1);
        System.out.println(tiny.getLongUrl(short1));


        System.out.println((long)Math.pow(62, 6));
        System.out.println(Integer.MAX_VALUE);

        System.out.println("c09c12030290d65c2c084114ba96a6ae53f85462e00df5298d1f44bcfb7b32e9".length());

        System.out.println("507f1f77bcf86cd799439011".length());
    }
}
