package greedy;

import java.util.Arrays;

public class Leetcode204 {

    public int countPrimes(int n) {
        if(n <= 2) return 0;

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        int count = n - 2;

        for(int i = 2; i < n; i++) {
            if(primes[i]) {
                for(int j = 2*i; j < n; j += i) {
                    if(primes[j]) {
                        primes[j] = false;
                        --count;
                    }
                }
            }
        }
        return count;
    }
}
