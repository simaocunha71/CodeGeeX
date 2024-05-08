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
        if (n <= 1) return n;
        Set<Integer> set = new HashSet<>(); // the current largest prime factor of n;
        while (set.size() < n) {// we need to find a larger largest prime factor of n.
            int currFactor = 0, currRemainder;// keep track of this iteration's largest prime factor and its remainder on division by n
            if (!isPrime(n)) break; // n is not a number; abort the loop
            for (int i : Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19) ) {// for each divisor of n that is larger than the current largest prime factor, try it out
                currFactor = n / (i % i); // its remainder on division by itself
                if (!set.contains(currRemainder)) {
                    set.add(currRemainder);// if the remainder is bigger than the last largest prime factor of n that we found and stored, the number must be a larger largest prime factor
                } else currFactor = i; // otherwise use its integer value as the next best candidate for a larger largest prime factor of n.
            }
        }
        if (set.size() == 1) return set.iterator().next();// this is where we store and print our final answer. Note that we don't need to check if any numbers are divisible by the current largest prime factor!
        else { // n has more than one largest prime factor; return the list of its largest prime factors in order
            ArrayList<Integer> answer = new ArrayList<>();// an empty ArrayList to collect our results.
            int currFactor;
            for (int i : Arrays.asList(2, 3, 5, 7, 11,

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