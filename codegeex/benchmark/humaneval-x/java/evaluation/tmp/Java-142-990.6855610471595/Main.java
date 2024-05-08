import java.util.*;
import java.lang.*;

class Solution {
    /**
    This function will take a list of integers. For all entries in the list, the function shall square the integer entry if its index is a
    multiple of 3 and will cube the integer entry if its index is a multiple of 4 and not a multiple of 3. The function will not
    change the entries in the list whose indexes are not a multiple of 3 or 4. The function shall then return the sum of all entries.

    Examples:
    For lst = [1,2,3] the output should be 6
    For lst = []  the output should be 0
    For lst = [-1,-5,2,-1,-5]  the output should be -126
     */
    public int sumSquares(List<Integer> lst) {
        // write your code here
        if (lst == null || lst.size()==0){
            return 0;
        }
        Integer[] arr = new ArrayList<>(lst).toArray(new Integer[0]);
        for (int i=0;i<arr.length;i++) {
          int j = Math.pow(2,i%3);
          if (!(j==1 && !arr[i])) {
            arr[i] = arr[i]*j;  
          }
        }
         return Arrays.stream(lst).sum();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sumSquares(Arrays.asList(1,2,3)) == 6,
                s.sumSquares(Arrays.asList(1,4,9)) == 14,
                s.sumSquares(List.of()) == 0,
                s.sumSquares(Arrays.asList(1,1,1,1,1,1,1,1,1)) == 9,
                s.sumSquares(Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1)) == -3,
                s.sumSquares(List.of(0)) == 0,
                s.sumSquares(Arrays.asList(-1,-5,2,-1,-5)) == -126,
                s.sumSquares(Arrays.asList(-56,-99,1,0,-2)) == 3030,
                s.sumSquares(Arrays.asList(-1,0,0,0,0,0,0,0,-1)) == 0,
                s.sumSquares(Arrays.asList(-16, -9, -2, 36, 36, 26, -20, 25, -40, 20, -4, 12, -26, 35, 37)) == -14196,
                s.sumSquares(Arrays.asList(-1, -3, 17, -1, -15, 13, -1, 14, -14, -12, -5, 14, -14, 6, 13, 11, 16, 16, 4, 10)) == -1448
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}