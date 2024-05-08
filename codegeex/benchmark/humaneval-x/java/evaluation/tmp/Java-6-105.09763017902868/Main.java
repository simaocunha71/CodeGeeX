import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input to this function is a string represented multiple groups for nested parentheses separated by spaces.
    For each of the group, output the deepest level of nesting of parentheses.
    E.g. (()()) has maximum two levels of nesting while ((())) has three.

    >>> parseNestedParens("(()()) ((())) () ((())()())")
    [2, 3, 1, 3]
     */
    public List<Integer> parseNestedParens(String paren_string) {
        // TODO: Write your code here.
        
        /*
                ( )
                  |
          (   )
              ||
            ||||
            
        */
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i=0; i < paren_string.length(); i++) {
           if(paren_string.charAt(i) == '(') {
               // we need to find how many () are there
               if(!map.containsKey(Character.valueOf(paren_string.charAt(i)))) {
                   map.put(Character.valueOf(paren_string.charAt(i)), new ArrayList<>());
               }
           } else if (paren_string.charAt(i) == ')') {
                List<Integer> list = map.get(Character.valueOf(paren_string.charAt(i)));
                // check for nested levels of parentheses
                int level = 1;
                do {
                    if (list.size() > level && list.get(level) > 0){
                        level++;
                    } else {
                        break;
                    }
                } while(true);
            }
        }
        List<Integer> solution = new ArrayList<>();
        
        for (int i=0; i < map.size(); i++) {
           solution.add((int)map.get(Character.valueOf(paren_string.charAt(i)).get(map.get(Character.valueOf(paren_string.charAt(i)).get(map.get(Character.valueOf(paren_

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.parseNestedParens("(()()) ((())) () ((())()())").equals(Arrays.asList(2, 3, 1, 3)),
                s.parseNestedParens("() (()) ((())) (((())))").equals(Arrays.asList(1, 2, 3, 4)),
                s.parseNestedParens("(()(())((())))").equals(Arrays.asList(4))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}