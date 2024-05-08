import java.util.*;
import java.lang.*;

class Solution {
    /**
    The Fib4 number sequence is a sequence similar to the Fibbonacci sequnece that's defined as follows:
    fib4(0) -> 0
    fib4(1) -> 0
    fib4(2) -> 2
    fib4(3) -> 0
    fib4(n) -> fib4(n-1) + fib4(n-2) + fib4(n-3) + fib4(n-4).
    Please write a function to efficiently compute the n-th element of the fib4 number sequence.  Do not use recursion.
    >>> fib4(5)
    4
    >>> fib4(6)
    8
    >>> fib4(7)
    14
     */
    public int fib4(int n) {
        if (n <= 0) return 0;
        long val = Fib4.fib4(n);
        return (val > 2147483647L ? -1 : (long)val);
    }
    
    static class Fib4 {
        private int[] sum, preSum; // 0 -> 0, 1 -> 0, 2 -> 1, ... , n-1 -> 0
        public void init(int n) {
            if (n <= 0) return;
            sum = new int[n];
            for (int i = 0; i < n; i++) {
                sum[i] = preSum[preSum.length - 1];
            }
        }
        
        public long fib4(int n) {
            if (n <= 0 || n > sum.length) return 0;
            long res = 0, a2 = sum[sum.length - 2], b2 = sum[sum.length - 3];
            
            for (int i = 0; i < sum.length; i++) {
                if(n == i) return i+1;
                
                // res += a2 * ((i-1)/8);
                res += (long)(a2 + b2)*((Math.PI/4

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fib4(5) == 4,
                s.fib4(8) == 28,
                s.fib4(10) == 104,
                s.fib4(12) == 386
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}