package easy;

public class Reverse_String_344 {

    public static String reverseString(String s) {
        int last = s.length()-1;
        StringBuilder sb = new StringBuilder();
        for(int i=last; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseString_2(String s) {
        if ("".equals(s)) {
            return "";
        }

        char[] chars = s.toCharArray();
        int last = s.length()-1;
        int path = s.length()/2;

        char c;
        for(int i=0; i<path; i++) {
            c = chars[i];
            chars[i] = chars[last-i];
            chars[last-i] = c;
        }

        return new String(chars);
    }

    public static String reverseString_3(String s) {

        char[] chars = s.toCharArray();
        int last = s.length()-1;
        int path = s.length()/2-1;

        for(int i=path; i>=0; i--) {
            chars[i] ^= chars[last-i];
            chars[last-i] ^= chars[i];
            chars[i] ^= chars[last-i];
        }

        return new String(chars);
    }

    public static String reverseString_4(String s) {
        char[] chars = s.toCharArray();
        int j = s.length()-1;
        int i = 0;

        while(i<j) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
            i++;
            j--;
        }
        return new String(chars);
    }

    public static String reverseString_5(String s) {
        if (s.length() > 1) {
            int middle = s.length()/2;
            return reverseString_5(s.substring(middle)) + reverseString_5(s.substring(0, middle));
        } else {
            return s;
        }
    }


    public static String reverseString_6(String s) {
        char [] c = s.toCharArray();
        char [] r = new char[c.length];
        int len = c.length-1;
        for (int i=len; i>=0; i--) {
            r[i] = c[len-i];
        }
        return new String(r);
    }

}
