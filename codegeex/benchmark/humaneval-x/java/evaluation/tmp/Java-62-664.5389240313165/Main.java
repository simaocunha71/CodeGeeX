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
        int x = 0;
        int coefXi = Integer.MAX_VALUE;
        for (int i : xs ) {
            if (xs[i].compareTo(x) > 0) {
                return null;
            }
            x += xs[i];
            coefXi -= xs[i];
        }
        int sum = -1;
        for (int i : xs ) {
            if (xs[i] < 0 || xs[i].compareTo(coefXi) > 0){
                return null;
            }
            sum += xs[i];
        }
        // now coefXi is the number we need
        int[] ans = new int[sum+1];
        int j = sum-1;
        for (int i : xs ) {
            if (i < j) { 
                // if i < j then coefXi - i > x and coefficient of
                // term (coefXi - i) * X is positive
                ans[j] += xs[i];    
            }    else {                  
                int y = Integer.MIN_VALUE; 
                for (int q = j+1 ; q<=sum-1 ; q++ ) { // for each term
                    if (xs[q].compareTo(x) > 0) continue;             
                    x -= xs[q];
                    y -= xs[q];
                    int wt = Math.min(y, Integer.MIN_VALUE);               
                    ans[j] +=

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