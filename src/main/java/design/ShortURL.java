package design;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by chenlijie on 12/2/17.
 */
public class ShortURL {
    static String idToShortURL(long n)
    {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuilder shorturl = new StringBuilder();

        // Convert given integer id to a base 62 number

        do {
            // use above map to store actual character
            // in short url
            shorturl.insert(0, map[(int)n%62]);
            n = n/62;
        } while (n != 0);

        return shorturl.toString();
    }

// Function to get integer ID back from a short url
    static long shortURLtoID(String url)
    {
        long id = 0; // initialize result
        char[] shortURL = url.toCharArray();
        // A simple base conversion logic
        for (int i=0; i < shortURL.length; i++)
        {
            if ('a' <= shortURL[i] && shortURL[i] <= 'z')
                id = id*62 + shortURL[i] - 'a';
            if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
                id = id*62 + shortURL[i] - 'A' + 26;
            if ('0' <= shortURL[i] && shortURL[i] <= '9')
                id = id*62 + shortURL[i] - '0' + 52;
        }
        return id;
    }


    public static void main(String[] args) {
        long n = 1;
        String shorturl = idToShortURL(n);
        System.out.println(shorturl);
        System.out.println(shortURLtoID(shorturl));

    }
}
