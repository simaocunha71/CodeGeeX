import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given an array of non-negative integers, return a copy of the given array after sorting,
    you will sort the given array in ascending order if the sum( first index value, last index value) is odd,
    or sort it in descending order if the sum( first index value, last index value) is even.

    Note:
    * don't change the given array.

    Examples:
    * sortArray(Arrays.asList()) => []
    * sortArray(Arrays.asList(5)) => [5]
    * sortArray(Arrays.asList(2, 4, 3, 0, 1, 5)) => [0, 1, 2, 3, 4, 5]
    * sortArray(Arrays.asList(2, 4, 3, 0, 1, 5, 6)) => [6, 5, 4, 3, 2, 1, 0]
     */
    public List<Integer> sortArray(List<Integer> array) {
        if (array.isEmpty()) return Collections.emptyList();
         //  int sum = array.get(0)+ array.get(array.size()-1);   // Sum of the first element and last element
        //  int oddSum = (sum + array.size());
       /* if (oddSum == (int) Math.abs((long) (Math.sqrt(array.size())+1)))) {                           // If sum is even then sort in descending order         System.out.println("Sorting Array in Descending Order");                                return sortArrayDescendent(array);}
        else if (sum == (int) Math.abs((long)(Math.sqrt(array.size())+1)))) {                           // If sum is odd then sort in ascending order         System.out.println("Sorting Array in Ascending Order");                                return sortArrayAscendent(array);}
        else   */ throw new RuntimeException();
    }
     public List<Integer> sortArrayDescendent(List<Integer> array) {
             //int oddSum = (sum

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortArray(new ArrayList<>(List.of())).equals(List.of()),
                s.sortArray(new ArrayList<>(List.of(5))).equals(List.of(5)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 4, 3, 0, 1, 5))).equals(Arrays.asList(0, 1, 2, 3, 4, 5)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 4, 3, 0, 1, 5, 6))).equals(Arrays.asList(6, 5, 4, 3, 2, 1, 0)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 1))).equals(Arrays.asList(1, 2)),
                s.sortArray(new ArrayList<>(Arrays.asList(15, 42, 87, 32 ,11, 0))).equals(Arrays.asList(0, 11, 15, 32, 42, 87)),
                s.sortArray(new ArrayList<>(Arrays.asList(21, 14, 23, 11))).equals(Arrays.asList(23, 21, 14, 11))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}