package ebay;

public class Print123 {

//    给 1 输出 1
//    给 2 输出 11,12,21,22（4个数）
//    给 3 输出 111,112,113,121,122,123,132,133,211,212,213,221,222,223,231,232,233,311,312,313,321,322,323,331,332,333 (27个数)

    static void print(int n) {
        print(n, new StringBuilder());
    }

    static void print(int n, StringBuilder builder) {
        if (builder.length() == n) {
            System.out.print(builder + ", ");
            return;
        }

        int len = builder.length();
        for (int i = 1; i <= n; i++) {
            builder.append(i);
            print(n, builder);
            builder.setLength(len);
        }
    }

    public static void main(String[] args) {
        print(3);
    }
}
