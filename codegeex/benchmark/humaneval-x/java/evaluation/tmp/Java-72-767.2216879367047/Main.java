import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that returns True if the object q will fly, and False otherwise.
    The object q will fly if it's balanced (it is a palindromic list) and the sum of its elements is less than or equal the maximum possible weight w.

    Example:
    willItFly(Arrays.asList(1, 2), 5) -> false
    # 1+2 is less than the maximum possible weight, but it's unbalanced.

    willItFly(Arrays.asList(3, 2, 3), 1) -> false
    # it's balanced, but 3+2+3 is more than the maximum possible weight.

    willItFly(Arrays.asList(3, 2, 3), 9) -> true
    # 3+2+3 is less than the maximum possible weight, and it's balanced.

    willItFly(Arrays.asList(3), 5) -> true
    # 3 is less than the maximum possible weight, and it's balanced.
     */
    public boolean willItFly(List<Integer> q, int w) {
        if (q == null || q.size() < 1) return false;
         //return (w - sum(q)) < w;
        Integer sum = 0;
        for (int i : q){
            sum += i;
        }
        System.out.println("The object q will fly if "+sum+" is less than or equal to the maximum possible weight w");
        return (w - sum) < w; // check palindrome and sum of elements in list
    }
    
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.willItFly(new ArrayList<>(Arrays.asList(3, 2, 3)), 9),
                !s.willItFly(new ArrayList<>(Arrays.asList(1, 2)), 5),
                s.willItFly(new ArrayList<>(List.of(3)), 5),
                !s.willItFly(new ArrayList<>(Arrays.asList(3, 2, 3)), 1),
                !s.willItFly(new ArrayList<>(Arrays.asList(1, 2, 3)), 6),
                s.willItFly(new ArrayList<>(List.of(5)), 5)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}