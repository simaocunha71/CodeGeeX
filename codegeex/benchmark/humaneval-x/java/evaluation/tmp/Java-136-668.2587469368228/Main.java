import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function that returns a tuple (a, b), where 'a' is
    the largest of negative integers, and 'b' is the smallest
    of positive integers in a list.
    If there is no negative or positive integers, return them as None.

    Examples:
    largestSmallestIntegers(Arrays.asList(2, 4, 1, 3, 5, 7)) == (Optional.empty(), Optional.of(1))
    largestSmallestIntegers(Arrays.asList()) == (Optional.empty(), Optional.empty())
    largestSmallestIntegers(Arrays.asList(0)) == (Optional.empty(), Optional.empty())
     */
    public List<Optional<Integer>> largestSmallestIntegers(List<Integer> lst){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Iterator itr = lst.iterator();
        if (itr.hasNext())
            a.add(itr.next());
        
        while (itr.hasNext()){
            b.add(itr.next());
        }
        
        int max = Math.max(a.stream().mapToInt((i)-> {return i;}).toArray())[0];
        int min = Math.min(b.stream().mapToInt((i)-> {return i;}).toArray())[0];
        
        if (max == -1 || b.size() == 0) return new ArrayList<>(2);
        else if (min == -1 || a.size() == 0) return new ArrayList<>(2);
        else{
            return new ArrayList<>(Arrays.asList(new Optional<>(max), new Optional<>(min)));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.largestSmallestIntegers(Arrays.asList(2, 4, 1, 3, 5, 7)).equals(Arrays.asList(Optional.empty(), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(2, 4, 1, 3, 5, 7, 0)).equals(Arrays.asList(Optional.empty(), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(1, 3, 2, 4, 5, 6, -2)).equals(Arrays.asList(Optional.of(-2), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(4, 5, 3, 6, 2, 7, -7)).equals(Arrays.asList(Optional.of(-7), Optional.of(2))),
                s.largestSmallestIntegers(Arrays.asList(7, 3, 8, 4, 9, 2, 5, -9)).equals(Arrays.asList(Optional.of(-9), Optional.of(2))),
                s.largestSmallestIntegers(List.of()).equals(Arrays.asList(Optional.empty(), Optional.empty())),
                s.largestSmallestIntegers(List.of(0)).equals(Arrays.asList(Optional.empty(), Optional.empty())),
                s.largestSmallestIntegers(Arrays.asList(-1, -3, -5, -6)).equals(Arrays.asList(Optional.of(-1), Optional.empty())),
                s.largestSmallestIntegers(Arrays.asList(-1, -3, -5, -6, 0)).equals(Arrays.asList(Optional.of(-1), Optional.empty())),
                s.largestSmallestIntegers(Arrays.asList(-6, -4, -4, -3, 1)).equals(Arrays.asList(Optional.of(-3), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(-6, -4, -4, -3, -100, 1)).equals(Arrays.asList(Optional.of(-3), Optional.of(1)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}