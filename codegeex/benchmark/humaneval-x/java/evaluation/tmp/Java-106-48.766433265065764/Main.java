import java.util.*;
import java.lang.*;

class Solution {
    /**
    Implement the function f that takes n as a parameter,
    and returns a list of size n, such that the value of the element at index i is the factorial of i if i is even
    or the sum of numbers from 1 to i otherwise.
    i starts from 1.
    the factorial of i is the multiplication of the numbers from 1 to i (1 * 2 * ... * i).
    Example:
    f(5) == [1, 2, 6, 24, 15]
     */
    public List<Integer> f(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n ; ++i){
            if (i % 2 == 1) {
                result.add((int) Math.pow(i, i));
            } else {
                result.add(i);
            }
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.f(5).equals(Arrays.asList(1, 2, 6, 24, 15)),
                s.f(7).equals(Arrays.asList(1, 2, 6, 24, 15, 720, 28)),
                s.f(1).equals(List.of(1)),
                s.f(3).equals(Arrays.asList(1, 2, 6))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}