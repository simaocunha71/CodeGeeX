import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return the largest prime factor of n. Assume n > 1 and is not a prime.
    >>> largestPrimeFactor(13195)
    29
    >>> largestPrimeFactor(2048)
    2
     */
    public int largestPrimeFactor(int n) {
        if (n <= 1) return 1;
        int p = 3, t = 2;
        
        while (true) {
            if (t * t == n) break;
            
            // check for prime numbers
            if ((p + 1 > Integer.MAX_VALUE / t || Math.pow(n, (p+1)/t) < p*t) && n % p == 0) {
                return p;
            } else {
                if (Math.pow(n, t/2) <= n && n % t == 0){
                    return t;
                }
                p++;
            }
        }
        
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.largestPrimeFactor(15) == 5,
                s.largestPrimeFactor(27) == 3,
                s.largestPrimeFactor(63) == 7,
                s.largestPrimeFactor(330) == 11,
                s.largestPrimeFactor(13195) == 29
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}