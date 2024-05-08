import java.util.*;
import java.lang.*;

class Solution {
    /**
    xs represent coefficients of a polynomial.
    xs[0] + xs[1] * x + xs[2] * x^2 + ....
     Return derivative of this polynomial in the same form.
    >>> derivative(Arrays.asList(3, 1, 2, 4, 5))
    [1, 4, 12, 20]
    >>> derivative(Arrays.asList(1, 2, 3]))
    [2, 6]
     */
    public List<Integer> derivative(List<Integer> xs) {
        if (xs == null || xs.size() < 2) return Collections.emptyList();
        int power = 0;
        for (int n : xs) {
            //power++;
            System.out.println("n:" + n);
        }
        return Arrays.asList(xs).stream().map((n) -> Integer.valueOf(Math.pow(10, power - 1)) * Math.pow(n, power)).collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.derivative(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))).equals(Arrays.asList(1, 4, 12, 20)),
                s.derivative(new ArrayList<>(Arrays.asList(1, 2, 3))).equals(Arrays.asList(2, 6)),
                s.derivative(new ArrayList<>(Arrays.asList(3, 2, 1))).equals(Arrays.asList(2, 2)),
                s.derivative(new ArrayList<>(Arrays.asList(3, 2, 1, 0, 4))).equals(Arrays.asList(2, 2, 0, 16)),
                s.derivative(List.of(1)).equals(List.of())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}