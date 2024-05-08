import java.util.*;
import java.lang.*;

class Solution {
    /**
    For a given list of integers, return a tuple consisting of a sum and a product of all the integers in a list.
    Empty sum should be equal to 0 and empty product should be equal to 1.
    >>> sumProduct(List.of())
    [0, 1]
    >>> sumProduct(Arrays.asList(1, 2, 3, 4))
    [10, 24]
     */
    public List<Integer> sumProduct(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : numbers){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1); 
            }else{
                 map.put(i, 1);
             }
         }
          return Arrays.asList(map.entrySet().stream()
              .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())).collect(Collectors.toList()))
                   .get(0).getValue();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sumProduct(new ArrayList<>(List.of())).equals(Arrays.asList(0, 1)),
                s.sumProduct(new ArrayList<>(Arrays.asList(1, 1, 1))).equals(Arrays.asList(3, 1)),
                s.sumProduct(new ArrayList<>(Arrays.asList(100, 0))).equals(Arrays.asList(100, 0)),
                s.sumProduct(new ArrayList<>(Arrays.asList(3, 5, 7))).equals(Arrays.asList(3 + 5 + 7, 3 * 5 * 7)),
                s.sumProduct(new ArrayList<>(List.of(10))).equals(Arrays.asList(10, 10))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}