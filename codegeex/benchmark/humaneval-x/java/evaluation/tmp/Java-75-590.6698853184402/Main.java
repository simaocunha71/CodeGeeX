import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that returns true if the given number is the multiplication of 3 prime numbers
    and false otherwise.
    Knowing that (a) is less then 100.
    Example:
    isMultiplyPrime(30) == true
    30 = 2 * 3 * 5
     */
    public boolean isMultiplyPrime(int a) {
        if(a < 1 || a > 100){ return false; }
        
        ArrayList<Integer> primes=new ArrayList<>();
        Arrays.sort(primes);
        boolean isPrime = true;
        int i = 0;
        while(i < a){
            if(!(isPrime)){
                isPrime = false;
                break;
            }
            primes.add((int)(Math.pow(2, i)));
            i++;
            
        }
        
        return true;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isMultiplyPrime(5),
                s.isMultiplyPrime(30),
                s.isMultiplyPrime(8),
                !s.isMultiplyPrime(10),
                s.isMultiplyPrime(125),
                s.isMultiplyPrime(3 * 5 * 7),
                !s.isMultiplyPrime(3 * 6 * 7),
                !s.isMultiplyPrime(9 * 9 * 9),
                !s.isMultiplyPrime(11 * 9 * 9),
                s.isMultiplyPrime(11 * 13 * 7)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}