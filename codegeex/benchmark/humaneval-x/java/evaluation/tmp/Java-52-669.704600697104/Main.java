import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return True if all numbers in the list l are below threshold t.
    >>> belowThreshold(Arrays.asList(1, 2, 4, 10), 100)
    true
    >>> belowThreshold(Arrays.asList(1, 20, 4, 10), 5)
    false
     */
    public boolean belowThreshold(List<Integer> l, int t) {
        if (l == null || l.isEmpty()) return true;
        Collections.sort(l);
        
	//if the list is empty or smaller than threshold then return it's empty
        if(l.size() < t){
            return false;
        }
        //if all elements in the list are smaller than threshold,
        for (int element : l) {
            if (element > t) {
                return false;
            } 
            
	}
        
        return true;
    }
    
//   public static void main(String[] args) {
//      Solution solution = new Solution();
//      
//      System.out.println("Is belowThreshold (1,20,4,10): " + 
//           solution.belowThreshold(Arrays.asList(1, 20, 4, 10), 5));
//   }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.belowThreshold(new ArrayList<>(Arrays.asList(1, 2, 4, 10)), 100),
                !s.belowThreshold(new ArrayList<>(Arrays.asList(1, 20, 4, 10)), 5),
                s.belowThreshold(new ArrayList<>(Arrays.asList(1, 20, 4, 10)), 21),
                s.belowThreshold(new ArrayList<>(Arrays.asList(1, 20, 4, 10)), 22),
                s.belowThreshold(new ArrayList<>(Arrays.asList(1, 8, 4, 10)), 11),
                !s.belowThreshold(new ArrayList<>(Arrays.asList(1, 8, 4, 10)), 10)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}