package amazon.onsite;

public class FindMissingNumber_2 {

    static int num = 100;

    static int[] bits = new int[num/32 + 1];

    static void add(int n) {
        bits[n/32] |= 1 << n%32;
    }

    static void print() {
        for (int i = 0; i < bits.length; i++) {
            for (int j = 31; j >= 0; j--) {
                if ((bits[i] & (1 << j)) != 0)
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
    }

    static void findMissingNumber() {
        print();

        for (int i = 0; i < num/32 + 1; i++) {

            for (int j = 0; j < 32; j++) {

                if ((bits[i] & (1 << j)) == 0) {
                    System.out.println(i * 32 + j);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        for (int i = Integer.MIN_VALUE; i <= num; i++) {
            if (i != 10)
                add(i);
        }

        findMissingNumber();
    }
}
