import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a non-empty list of integers lst. add the even elements that are at odd indices..

    Examples:
        add(Arrays.asList(4, 2, 6, 7)) ==> 2
     */
    public int add(List<Integer> lst) {
        
       return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.add(new ArrayList<>(Arrays.asList(4, 88))) == 88,
                s.add(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 2, 122))) == 122,
                s.add(new ArrayList<>(Arrays.asList(4, 0, 6, 7))) == 0,
                s.add(new ArrayList<>(Arrays.asList(4, 4, 6, 8))) == 12
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}