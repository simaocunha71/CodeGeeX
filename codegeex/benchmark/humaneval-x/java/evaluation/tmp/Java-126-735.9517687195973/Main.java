import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a list of numbers, return whether or not they are sorted
    in ascending order. If list has more than 1 duplicate of the same
    number, return false. Assume no negative numbers and only integers.

    Examples
    isSorted(Arrays.asList(5)) -> true
    isSorted(Arrays.asList(1, 2, 3, 4, 5)) -> true
    isSorted(Arrays.asList(1, 3, 2, 4, 5)) -> false
    isSorted(Arrays.asList(1, 2, 3, 4, 5, 6)) -> true
    isSorted(Arrays.asList(1, 2, 3, 4, 5, 6, 7)) -> true
    isSorted(Arrays.asList(1, 3, 2, 4, 5, 6, 7)) -> false
    isSorted(Arrays.asList(1, 2, 2, 3, 3, 4)) -> true
    isSorted(Arrays.asList(1, 2, 2, 2, 3, 4)) -> false
     */
    public boolean isSorted(List<Integer> lst) {
        if (lst == null || lst.size() < 2) return true;
        ArrayList<Object> al = new ArrayList<>();
        for (int e : lst) al.add(e);
        Collections.sort(al);
        Iterator<Object> itr = al.iterator();
        int i = 1, j = 0;
        while (i < lst.size()) {
            if (!lst.get(i).equals(itr.next())) return false;
            i++;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isSorted(new ArrayList<>(List.of(5))) == true,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))) == true,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5))) == false,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))) == true,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))) == true,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5, 6, 7))) == false,
                s.isSorted(new ArrayList<>(List.of())) == true,
                s.isSorted(new ArrayList<>(List.of(1))) == true,
                s.isSorted(new ArrayList<>(Arrays.asList(3, 2, 1))) == false,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 4))) == false,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 4))) == false,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4))) == true,
                s.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4))) == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}