package amazon.onsite;

import java.util.ArrayList;
import java.util.List;

public class FindAllPrimeNumber {


    static List<Integer> findAllPrimes(int num) {
        if (num < 2)
            return new ArrayList<>();

        boolean[] notPrime = new boolean[num + 1];

        for (int i = 2; i <= num/2; i++) {

            if (!notPrime[i]) {
                int j = 2;
                while (j * i <= num) notPrime[j++ * i] = true;
            }

        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (!notPrime[i]) {
                ans.add(i);
            }
        }

        System.out.println(ans);

        return ans;
    }

    static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                ans.add(i);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        findAllPrimes(1000);
        sieveOfEratosthenes(1000);
    }
}
