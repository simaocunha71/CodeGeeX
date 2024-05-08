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
        if (numbers == null || numbers.isEmpty()) return new ArrayList<>();
        List<Object> list = new ArrayList<>();
        if (delimiter > 1) list.add(new Object());
        for (int i = 0; i < numbers.size(); i++) {
            list.add(numbers.get(i));
        }
        if (list.size() % 2 != 0 || delimiter == 0) return new ArrayList<>(list);
        else {
            int idx = Math.max((list.size() - 1) / 2, 0); // to add the last element at the end of the list
            for (int i = 1; i < idx + 1; i++) {
                list.add(new Object());
            }
            return new ArrayList<>(list);
        }
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