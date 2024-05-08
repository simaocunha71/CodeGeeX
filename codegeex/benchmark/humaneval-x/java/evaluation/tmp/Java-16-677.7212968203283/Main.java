import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string, find out how many distinct characters (regardless of case) does it consist of
    >>> countDistinctCharacters("xyzXYZ")
    3
    >>> countDistinctCharacters("Jerry")
    4
     */
    public int countDistinctCharacters(String string) {
        Set<Character> distinctChars = new HashSet<>();
        
        String[] parts = string.split("");
        if (parts == null || parts[0] != "") {
            distinctChars.addAll(Arrays.asList(parts));
            
            return countDistinctCharacters(distinctChars);
        } else if (!string.equals("")) {
            return distinctChars.size();
        }
        
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.countDistinctCharacters("") == 0,
                s.countDistinctCharacters("abcde") == 5,
                s.countDistinctCharacters("abcde" + "cade" + "CADE") == 5,
                s.countDistinctCharacters("aaaaAAAAaaaa") == 1,
                s.countDistinctCharacters("Jerry jERRY JeRRRY") == 5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}