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
        List<Integer> factors = new ArrayList<>();
        for (int i=1;i<n+1;i++) {
            if (Math.abs(i%2) == 0 && n > 1) {
                int temp = Math.pow(i, n);
                if (i==1 || temp>=0) {
                    factors.add(temp);
                } else {
                    for (int j=1;j<=Math.abs(n/2);j++) {
                        if (j==1) continue;
                        int sum = 1 + j;
                        factors.add(sum);
                    }
                }
            } else {
                for (int j=1;j<=Math.abs(n/2)+1;j++) {
                    if (j==1) continue;
                    int sum = 1 + j;
                    factors.add(sum);
                }
            }
        }
        return factors;
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