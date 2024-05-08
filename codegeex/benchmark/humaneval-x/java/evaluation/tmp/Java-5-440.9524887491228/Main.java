import java.util.*;
import java.lang.*;

class Solution {
    /**
    Insert a number 'delimeter' between every two consecutive elements of input list `numbers'
    >>> intersperse(List.of(), 4)
    []
    >>> intersperse(Arrays.asList(1, 2, 3), 4)
    [1, 4, 2, 4, 3]
     */
    public List<Integer> intersperse(List<Integer> numbers, int delimiter) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i!=numbers.size();++i){
            list.add((i==0?num:num+delimiter).toString());
        }
        return Collections.unmodifiableList(list);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.intersperse(new ArrayList<>(List.of()), 7).equals(List.of()),
                s.intersperse(new ArrayList<>(Arrays.asList(5, 6, 3, 2)), 8).equals(Arrays.asList(5, 8, 6, 8, 3, 8, 2)),
                s.intersperse(new ArrayList<>(Arrays.asList(2, 2, 2)), 2).equals(Arrays.asList(2, 2, 2, 2, 2))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}