package amazon.onsite;

public class SerilizeString {

    //大概就是字符串序列化，比如3[ab]cd => abababcd（可能有嵌套），
    // 我用stack实现了代码，但他问我有没有其他实现方法，我觉得可以用递归，
    // 貌似这是他期望的答案，但我没想出来具体怎么实现

    static String serilize(String str) {
        String s = serilize(str, 0, str.length() - 1);
        System.out.println(s);
        return s;
    }

    static String serilize(String str, int start, int end) {
        if (str == null)
            return "";

        StringBuilder builder = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (Character.isDigit(str.charAt(i))) {
                int repeat = str.charAt(i) - '0';
                int j = str.lastIndexOf(']', end);

                String s = serilize(str, i + 1, j - 1);

                while (repeat-- > 0) builder.append(s);

                i = j;
            } else if (Character.isAlphabetic(str.charAt(i))) {
                builder.append(str.charAt(i));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        serilize("2[a2[b]d]");
        serilize("2[a3[c1[z]]b]");
    }
}
