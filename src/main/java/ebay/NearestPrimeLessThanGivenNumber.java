package ebay;

public class NearestPrimeLessThanGivenNumber {

    static int nearest(int n) {
        boolean[] notPrimes = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (!notPrimes[i]) {
                mark(i, n, notPrimes);
            }
        }

        for (int i = n - 1; i >= 2; i--) {
            if (!notPrimes[i])
                return i;
        }

        return -1;
    }

    static void mark(int i, int n, boolean[] notPrimes) {
        for (int j = i * 2; j < n; j += i) {
            notPrimes[j] = true;
        }
    }

    public static void main(String[] args) {
        System.out.println(nearest(100));
    }
}
