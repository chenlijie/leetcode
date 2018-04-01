package microsoft;

public class MakeNumbersMatch {

    static void makeNumbersMatch(int a, int b, int x, int y){
        while(a != x || b != y){
            if(a > x){
                a--;
            } else if(a < x){
                a++;
            }
            if(b > y){
                b--;
            } else if (b < y){
                b++;
            }
        }

        System.out.println(a == x);
        System.out.println(b == y);
    }

    public static void main(String[] args) {
        makeNumbersMatch(1, 100, 30, 60);
    }

}
