import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return true if a given number is prime, and false otherwise.
    >>> isPrime(6)
    false
    >>> isPrime(101)
    true
    >>> isPrime(11)
    true
    >>> isPrime(13441)
    true
    >>> isPrime(61)
    true
    >>> isPrime(4)
    false
    >>> isPrime(1)
    false
     */
    public boolean isPrime(int n) {
        if (n == 0 || n < 2) return false; // 小于 2 或者 为 0 都不会出现，所以直接忽略
        
        if (n % 2 == 0 && n != 2) { return false; } // 小于 2 之后，如果是 2 就返回 false，而且递归不会到 n 的下一步（直接返回）
        
        if (n % 3 == 0 && n != 3) { return false; } // 小于 3 之后，如果是 3 就返回 false，而且递彩不会到 n 的下一步（直接返回）
        
        if (n % 5 == 0 && n != 5) { return false; } // 小于 5 之后，如果是 5 就返回 false，而且递彩不会到 n 的下一步（直接返回）
        
        if (n % 7 == 0 && n != 7) { return false; } // 小于 7 之后，如果是 7 就返回 false，而且递彩不会到 n 的下一步（直接返回）
        
        if (n % 11 == 0 && n != 11) { return false; } // 小于 11 之

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isPrime(6),
                s.isPrime(101),
                s.isPrime(11),
                s.isPrime(13441),
                s.isPrime(61),
                !s.isPrime(4),
                !s.isPrime(1),
                s.isPrime(5),
                s.isPrime(11),
                s.isPrime(17),
                !s.isPrime(5 * 17),
                !s.isPrime(11 * 7),
                !s.isPrime(13441 * 19)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}