import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given an array arr of integers and you need to return
    sum of magnitudes of integers multiplied by product of all signs
    of each number in the array, represented by 1, -1 or 0.
    Note: return None for empty arr.

    Example:
    >>> prodSigns(Arrays.asList(1, 2, 2, -4)) == -9
    >>> prodSigns(Arrays.asList(0, 1)) == 0
    >>> prodSigns(Arrays.asList()) == None
     */
    public Optional<Integer> prodSigns(List<Integer> arr) {
        return Optional.ofNullable(arr).map(new ProdSignFct()::prodSign);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.prodSigns(Arrays.asList(1, 2, 2, -4)).get() == -9,
                s.prodSigns(Arrays.asList(0, 1)).get() == 0,
                s.prodSigns(Arrays.asList(1, 1, 1, 2, 3, -1, 1)).get() == -10,
                s.prodSigns(List.of()).isEmpty(),
                s.prodSigns(Arrays.asList(2, 4,1, 2, -1, -1, 9)).get() == 20,
                s.prodSigns(Arrays.asList(-1, 1, -1, 1)).get() == 4,
                s.prodSigns(Arrays.asList(-1, 1, 1, 1)).get() == -4,
                s.prodSigns(Arrays.asList(-1, 1, 1, 0)).get() == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}