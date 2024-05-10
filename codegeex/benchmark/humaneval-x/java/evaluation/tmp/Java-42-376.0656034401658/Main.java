import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Solution {
    /**
    Return list with elements incremented by 1.
    >>> incrList(Arrays.asList(1, 2, 3))
    [2, 3, 4]
    >>> incrList(Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123))
    [6, 4, 6, 3, 4, 4, 10, 1, 124]
     */
    public List<Integer> incrList(List<Integer> l) {
        List<Integer> incremented = new ArrayList<>();
        for (int e :l){
            incremented.add(e+1);
        }
        return incremented;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.incrList(new ArrayList<>(Arrays.asList())).equals(List.of()),
                s.incrList(new ArrayList<>(Arrays.asList(3, 2, 1))).equals(Arrays.asList(4, 3, 2)),
                s.incrList(new ArrayList<>(Arrays.asList(5, 2, 5, 2, 3, 3, 9, 0, 123))).equals(Arrays.asList(6, 3, 6, 3, 4, 4, 10, 1, 124))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}