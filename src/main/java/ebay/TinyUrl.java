package ebay;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.Map;
import java.util.TreeMap;

public class TinyUrl {

    static long counter = Integer.MAX_VALUE * 2L;
    static char[] c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    static Map<String, String> map = new TreeMap<>();
    static String prefix = "http://tinyurl.com/";

    static String encode(String longUrl) {
        StringBuilder builder = new StringBuilder(prefix);
        long num = counter;

        while (num > 0) {
            builder.append(c[(int)(num % 62)]);
            num /= 62;
        }

        String shortUrl = builder.toString();

        System.out.println("encode - long url: " + longUrl + ", counter: " + counter + ", short url: " + shortUrl);

        map.put(shortUrl, longUrl);
        counter++;

        return shortUrl;
    }

    // a-z : 0-25
    // A-Z : 26-51
    // 0-9 : 52-61
    static String decode(String shortUrl) {
        String str = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        long n = 0L;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                n += (c - '0' + 52) * Math.pow(62, i);
            } else if (Character.isUpperCase(c)) {
                n += (c - 'A' + 26) * Math.pow(62, i);
            } else {
                n += (c - 'a') * Math.pow(62, i);
            }
        }

        System.out.println("decode - long url: " + map.get(shortUrl) + ", counter: " + n + ", short url: " + shortUrl);

        return map.get(shortUrl);
    }

    public static void main(String[] args) {

//        int[] arr = new int[Integer.MAX_VALUE];

        System.out.println((long)Math.pow(62, 6));
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Math.pow(62, 6) > Integer.MAX_VALUE);

        for (int i = 0; i < 10; i++) {
            encode("http://test.com/longurl_" + i);
        }

        System.out.println("**********************************");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            decode(entry.getKey());
        }
    }
}
//        long url: http://test.com/longurl_0, counter: 139847224, short url: http://tinyurl.com/yOWCj
//        long url: http://test.com/longurl_1, counter: 139847225, short url: http://tinyurl.com/zOWCj
//        long url: http://test.com/longurl_2, counter: 139847226, short url: http://tinyurl.com/AOWCj
//        long url: http://test.com/longurl_3, counter: 139847227, short url: http://tinyurl.com/BOWCj
//        long url: http://test.com/longurl_4, counter: 139847228, short url: http://tinyurl.com/COWCj
//        long url: http://test.com/longurl_5, counter: 139847229, short url: http://tinyurl.com/DOWCj
//        long url: http://test.com/longurl_6, counter: 139847230, short url: http://tinyurl.com/EOWCj
//        long url: http://test.com/longurl_7, counter: 139847231, short url: http://tinyurl.com/FOWCj
//        long url: http://test.com/longurl_8, counter: 139847232, short url: http://tinyurl.com/GOWCj
//        long url: http://test.com/longurl_9, counter: 139847233, short url: http://tinyurl.com/HOWCj
//        *************************
//        long url: http://test.com/longurl_2, counter: 139847226, short url: http://tinyurl.com/AOWCj
//        long url: http://test.com/longurl_3, counter: 139847227, short url: http://tinyurl.com/BOWCj
//        long url: http://test.com/longurl_4, counter: 139847228, short url: http://tinyurl.com/COWCj
//        long url: http://test.com/longurl_5, counter: 139847229, short url: http://tinyurl.com/DOWCj
//        long url: http://test.com/longurl_6, counter: 139847230, short url: http://tinyurl.com/EOWCj
//        long url: http://test.com/longurl_7, counter: 139847231, short url: http://tinyurl.com/FOWCj
//        long url: http://test.com/longurl_8, counter: 139847232, short url: http://tinyurl.com/GOWCj
//        long url: http://test.com/longurl_9, counter: 139847233, short url: http://tinyurl.com/HOWCj
//        long url: http://test.com/longurl_0, counter: 139847224, short url: http://tinyurl.com/yOWCj
//        long url: http://test.com/longurl_1, counter: 139847225, short url: http://tinyurl.com/zOWCj