import java.util.*;
import java.lang.*;

class Solution {
    /**
    In this Kata, you have to sort an array of non-negative integers according to
    number of ones in their binary representation in ascending order.
    For similar number of ones, sort based on decimal value.
    <p>
    It must be implemented like this:
    >>> sortArray(Arrays.asList(1, 5, 2, 3, 4)).equals(Arrays.asList(1, 2, 3, 4, 5))
    >>> sortArray(Arrays.asList(-2, -3, -4, -5, -6)).equals(Arrays.asList(-6, -5, -4, -3, -2))
    >>> sortArray(Arrays.asList(1, 0, 2, 3, 4)).equals(Arrays.asList(0, 1, 2, 3, 4))
     */
    public List<Integer> sortArray(List<Integer> arr) {
        // Sorting algorithm
        int[] dec = new int[arr.size()];
        for (int i=0;i<dec.length;i++) {
            for (int j=0;j<arr.get(i).bitLength();j++) {
                if ((j+1)%2==0) // Get the value of dec as decimal
                    dec[arr.indexOf(arr.get(i))-1] += arr.get(i);
            }
        }
        
        for (int i=0;i<dec.length;i++) {
            if (!Double.isInfinite(dec[i])) // If we have infinite decimal value then return it in its current place
                return Arrays.asList(dec[i]);
        }
        
        List<Integer> sorted = new ArrayList<>();
        for (int i=0;i<arr.size();i++) {
            if (!Double.isInfinite(dec[arr.indexOf(arr.get(i))-1]))// If value is not infinite, add it to the sorted list
                sorted.add(dec[arr.indexOf(arr.get(i))-

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortArray(new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4))).equals(Arrays.asList(1, 2, 4, 3, 5)),
                s.sortArray(new ArrayList<>(Arrays.asList(-2, -3, -4, -5, -6))).equals(Arrays.asList(-4, -2, -6, -5, -3)),
                s.sortArray(new ArrayList<>(Arrays.asList(1, 0, 2, 3, 4))).equals(Arrays.asList(0, 1, 2, 4, 3)),
                s.sortArray(new ArrayList<>(List.of())).equals(List.of()),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 5, 77, 4, 5, 3, 5, 7, 2, 3, 4))).equals(Arrays.asList(2, 2, 4, 4, 3, 3, 5, 5, 5, 7, 77)),
                s.sortArray(new ArrayList<>(Arrays.asList(3, 6, 44, 12, 32, 5))).equals(Arrays.asList(32, 3, 5, 6, 12, 44)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32))).equals(Arrays.asList(2, 4, 8, 16, 32)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 4, 8, 16, 32))).equals(Arrays.asList(2, 4, 8, 16, 32))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}