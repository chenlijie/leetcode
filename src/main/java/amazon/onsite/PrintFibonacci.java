package amazon.onsite;

public class PrintFibonacci {

    static void print(int n) {
        if (n <= 0) return;

        int x = 1;
        int y = 1;
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                System.out.print(1 + " ");
            } else {
                int t = x;
                x = y;
                y = t + y;
                System.out.print(y + " ");
            }
        }

    }

    public static void main(String[] args) {
        print(2);
    }
}
