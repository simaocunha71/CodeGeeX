import java.util.*;
import java.lang.*;

class Solution {
    /**
    Implement a function that takes an non-negative integer and returns an array of the first n
    integers that are prime numbers and less than n.
    for example:
    countUpTo(5) => [2,3]
    countUpTo(11) => [2,3,5,7]
    countUpTo(0) => []
    countUpTo(20) => [2,3,5,7,11,13,17,19]
    countUpTo(1) => []
    countUpTo(18) => [2,3,5,7,11,13,17]
     */
    public List<Integer> countUpTo(int n) {
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i=2; i<=n ;i++){
            if (isPrime(primeList, i)){
                if (!(primeList.contains(i)))
                    primeList.add(i);
            }
        }
        return primeList;
    }
    
    public boolean isPrime(ArrayList<Integer> primeList, int input) {
        for (int i=2 ; i<=input/2 ; i++){
            if ((primeList.contains(i)) && (input%i==0)){
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.countUpTo(5).equals(Arrays.asList(2, 3)),
                s.countUpTo(6).equals(Arrays.asList(2, 3, 5)),
                s.countUpTo(7).equals(Arrays.asList(2, 3, 5)),
                s.countUpTo(10).equals(Arrays.asList(2, 3, 5, 7)),
                s.countUpTo(0).equals(List.of()),
                s.countUpTo(22).equals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)),
                s.countUpTo(1).equals(List.of()),
                s.countUpTo(18).equals(Arrays.asList(2, 3, 5, 7, 11, 13, 17)),
                s.countUpTo(47).equals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43)),
                s.countUpTo(101).equals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}