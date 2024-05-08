import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a non-empty array of integers arr and an integer k, return
    the sum of the elements with at most two digits from the first k elements of arr.

    Example:

        Input: arr = [111,21,3,4000,5,6,7,8,9], k = 4
        Output: 24 # sum of 21 + 3

    Constraints:
        1. 1 <= len(arr) <= 100
        2. 1 <= k <= len(arr)
     */
    public int addElements(List<Integer> arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i)+1);
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(!map.containsKey((int)Math.pow(2, k-k/len(arr))+1))
                continue;
            else if(Math.abs(entry.getValue()-1) > 9){
                sum += Math.abs(entry.getValue()-1);
                break;
            }else
                sum+=entry.getValue();
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.addElements(Arrays.asList(1, -2, -3, 41, 57, 76, 87, 88, 99), 3) == -4,
                s.addElements(Arrays.asList(111, 121, 3, 4000, 5, 6), 2) == 0,
                s.addElements(Arrays.asList(11, 21, 3, 90, 5, 6, 7, 8, 9), 4) == 125,
                s.addElements(Arrays.asList(111, 21, 3, 4000, 5, 6, 7, 8, 9), 4) == 24,
                s.addElements(Arrays.asList(1), 1) == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}