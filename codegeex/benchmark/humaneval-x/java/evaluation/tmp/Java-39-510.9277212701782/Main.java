import java.util.*;
import java.lang.*;

class Solution {
    /**
    primeFib returns n-th number that is a Fibonacci number and it's also prime.
    >>> primeFib(1)
    2
    >>> primeFib(2)
    3
    >>> primeFib(3)
    5
    >>> primeFib(4)
    13
    >>> primeFib(5)
    89
     */
    public int primeFib(int n) {
        if (n <= 0 || n == 1) return 2;
        long[] fibs = new long[n+1];
        fibs[1] = 2;
        fibs[2] = 3;
        for (int i=3; i<=n; i++) {
            fibs[i] = fibs[i-1]+fibs[i-2];
        }
        for(int i=0; i<n; i++) {
            if(isPrime(fibs[i])) return (long)fibs[i];
        }
        
        return -1;
    }
    
    isPrime checks if the integer is a prime number.
    >>> isPrime(-1)
    false
    >>> isPrime(0)
    true
    >>> isPrime(1)
    false
    >>> isPrime(2)
    true
    >>> isPrime(3)
    true
    ***/
    private boolean isPrime (long n) {
        if (n == 1 || n == 0) return true; // base cases.
        
        long sum = 1;
        int i=2;
        while(i< Math.sqrt(Math.pow((double)n, 2))+1) {
            if (n % i==0) {
                boolean isDivisibleByOdds = true;
                for (long j: n/i*i) {
                    sum += (j * i); // add the number in the factorial.
                    isDivisibleByOdds = !(n % j == 0 && i

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.primeFib(1) == 2,
                s.primeFib(2) == 3,
                s.primeFib(3) == 5,
                s.primeFib(4) == 13,
                s.primeFib(5) == 89,
                s.primeFib(6) == 233,
                s.primeFib(7) == 1597,
                s.primeFib(8) == 28657,
                s.primeFib(9) == 514229,
                s.primeFib(10) == 433494437
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}