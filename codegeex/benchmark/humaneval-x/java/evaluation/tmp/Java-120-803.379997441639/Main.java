import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given an array arr of integers and a positive integer k, return a sorted list
    of length k with the maximum k numbers in arr.

    Example 1:

        Input: arr = [-3, -4, 5], k = 3
        Output: [-4, -3, 5]

    Example 2:

        Input: arr = [4, -4, 4], k = 2
        Output: [4, 4]

    Example 3:

        Input: arr = [-3, 2, 1, 2, -1, -2, 1], k = 1
        Output: [2]

    Note:
        1. The length of the array will be in the range of [1, 1000].
        2. The elements in the array will be in the range of [-1000, 1000].
        3. 0 <= k <= len(arr)
     */
    public List<Integer> maximum(List<Integer> arr, int k) {
        Collections.sort(arr);
        if (k == 0) return new ArrayList();
       /* for (int i = 0; i < arr.size(); i++)
            {
                if(i+1 >= k-1) break;
                    if(arr.get(i)+1>=k) continue;*/
        int p=0,q=0;
        while((p<(arr.size()-1))&&(!(q>>(int)(Math.pow(2,p))))){
            q=(int)(Math.pow(2,p));
            if(q>=k) continue;
            arr.add(q);
            p++;}
        return new ArrayList<Integer>(arr);
    }
};
/**
Given an array of numbers and a positive integer k, write a program to generate
a sorted list with the maximum length of k numbers selected from the array. If
the list is too big for k space available then leave it as it is and return false; otherwise return true.
Note that the list should be 1-based.
Example 1

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.maximum(new ArrayList<>(Arrays.asList(-3, -4, 5)), 3).equals(Arrays.asList(-4, -3, 5)),
                s.maximum(new ArrayList<>(Arrays.asList(4, -4, 4)), 2).equals(Arrays.asList(4, 4)),
                s.maximum(new ArrayList<>(Arrays.asList(-3, 2, 1, 2, -1, -2, 1)), 1).equals(List.of(2)),
                s.maximum(new ArrayList<>(Arrays.asList(123, -123, 20, 0 , 1, 2, -3)), 3).equals(Arrays.asList(2, 20, 123)),
                s.maximum(new ArrayList<>(Arrays.asList(-123, 20, 0 , 1, 2, -3)), 4).equals(Arrays.asList(0, 1, 2, 20)),
                s.maximum(new ArrayList<>(Arrays.asList(5, 15, 0, 3, -13, -8, 0)), 7).equals(Arrays.asList(-13, -8, 0, 0, 3, 5, 15)),
                s.maximum(new ArrayList<>(Arrays.asList(-1, 0, 2, 5, 3, -10)), 2).equals(Arrays.asList(3, 5)),
                s.maximum(new ArrayList<>(Arrays.asList(1, 0, 5, -7)), 1).equals(List.of(5)),
                s.maximum(new ArrayList<>(Arrays.asList(4, -4)), 2).equals(Arrays.asList(-4, 4)),
                s.maximum(new ArrayList<>(Arrays.asList(-10, 10)), 2).equals(Arrays.asList(-10, 10))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}