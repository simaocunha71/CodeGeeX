import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer n, return a sorted list that has the odd numbers in collatz sequence.

    The Collatz conjecture is a conjecture in mathematics that concerns a sequence defined
    as follows: start with any positive integer n. Then each term is obtained from the
    previous term as follows: if the previous term is even, the next term is one half of
    the previous term. If the previous term is odd, the next term is 3 times the previous
    term plus 1. The conjecture is that no matter what value of n, the sequence will always reach 1.

    Note:
        1. Collatz(1) is [1].
        2. returned list sorted in increasing order.

    For example:
    getOddCollatz(5) returns [1, 5] # The collatz sequence for 5 is [5, 16, 8, 4, 2, 1], so the odd numbers are only 1, and 5.
     */
    public List<Integer> getOddCollatz(int n) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0;
        // loop through all even number to find any odd number
        while (i < n && collatzHelper(n, i)) {
            if (isOdd(n)) {
                result.add((int) Math.floorDiv(3 * (2 + n), 2));
            }
            i++;
        }
        
        return result;
    }
    
    private boolean collatzHelper(int m, int curr){
        if(m == 0 || m < 1) { // no need to test for even number and odd numbers.
            return false;
        } else {
            return collatzHelper(m - (2 + curr), curr);
        }
    }  
    private boolean isOdd(int n){
        if(n == 0) {
            System.out.println("is odd");
            return true;
        } else {
        	return n % 2 != 0;
    	}
        /*
     * The function has three

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.getOddCollatz(14).equals(Arrays.asList(1, 5, 7, 11, 13, 17)),
                s.getOddCollatz(5).equals(Arrays.asList(1, 5)),
                s.getOddCollatz(12).equals(Arrays.asList(1, 3, 5)),
                s.getOddCollatz(1).equals(List.of(1))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}