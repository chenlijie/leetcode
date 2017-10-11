package complexity;

/**
 * Created by chenlijie on 9/19/17.
 */
public class SystemOutPrintln {

    public static void main(String[] args) {

//        powers0f2(3);
    }

    static int powers0f2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powers0f2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    static void complexityOfPrint() {
        long a, b;
        long s = System.currentTimeMillis();
        for(int i = 0;i < 100000;++i)
            System.out.println("a");
        long e = System.currentTimeMillis();
        a = e-s;

        s = System.currentTimeMillis();
        for(int i = 0;i < 100000;++i)
            System.out.println("asdhasdyasiluftyiufhiuasydfuadsfsluftiluftyiufhiuasydfuadsfsluftiluftyiufhiuasydfuadsfsluftiluftyiufhiuasydfuadsfsluftiluftyiufhiuasydfuadsfsluftiluftyiufhiuasydfuadsfsluftiluftyiufhiuasydfuadsfsluftyiufhiuasydfuadsfsluftyiufhiuasydfuadsfsluftyiufhiuasydfuadsfsluftyiufhiuasydfuadsfsadfsadfdsfasdfsdfffffffffdsafdsfdsfsfsfsdfsdfjshaskljdaklsdhkajsasdjhakjshakjsfgajskgjfgdsajfgasdkjgadviuasgdfmnasdbfjgsdyjakdhggggggggcjhasdfjkgsjkdfgsdfhgdsfdsfgalsdkjfdhkagsdjkasdjd");
        e = System.currentTimeMillis();
        b = e-s;
        System.out.println(a);
        System.out.println(b);
    }
}
