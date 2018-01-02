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
    Map<Integer, String> db = new HashMap<>();
    int incresedId = 0;

    String getShortUrl(String longUrl) {
        int id = ++incresedId;

        char[] c = new char[6];
        int i = 5;

        while (id != 0) {
            c[i--] = map[id%62];
            id /= 62;
        }

        String shortUrl = new String(c);
        db.put(incresedId, longUrl);
        return shortUrl;
    }

    String getLongUrl(String shortUrl) {
        int sum = 0;
        for (int i = 0; i < shortUrl.length(); i++) {
            char c = shortUrl.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sum += Math.pow(62, 5-i) * (c-'a');
            } else if (c >= 'A' && c <= 'Z') {
                sum += Math.pow(62, 5-i) * (c-'A'+26);
            } else if (c >= '0' && c <= '9'){
                sum += Math.pow(62, 5-i) * (c-'0'+52);
            }
        }
        return db.get(sum);
    }

    public static void main(String[] args) {
        TinyUrl tiny = new TinyUrl();
//        tiny.incresedId = Integer.MAX_VALUE-10;
//        String long1 = "jimmy";
//        String short1 = tiny.getShortUrl(long1);
//        System.out.println(short1);
//        System.out.println(tiny.getLongUrl(short1));

//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            String long1 = "jimmy" + i;
//            String short1 = tiny.getShortUrl(long1);
//            System.out.println(short1 + " : " + tiny.getLongUrl(short1));
//        }

        System.out.println(Math.pow(62, 6));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
