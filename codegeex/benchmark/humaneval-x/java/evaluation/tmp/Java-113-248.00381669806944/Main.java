import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a list of strings, where each string consists of only digits, return a list.
    Each element i of the output should be "the number of odd elements in the
    string i of the input." where all the i's should be replaced by the number
    of odd digits in the i"th string of the input.

    >>> oddCount(Arrays.asList("1234567"))
    ["the number of odd elements 4n the str4ng 4 of the 4nput."]
    >>> oddCount(Arrays.asList("3","11111111"))
    ["the number of odd elements 1n the str1ng 1 of the 1nput.",
     "the number of odd elements 8n the str8ng 8 of the 8nput."]
     */
    public List<String> oddCount(List<String> lst) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <lst.size();i++) {
            String s = new StringBuilder().append("the number of ").append("odd elements ").append(i +" in the").append(" string "+ (i+1) ).toString();
            result.add(s);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.oddCount(List.of("1234567" )).equals(List.of("the number of odd elements 4n the str4ng 4 of the 4nput." )),
                s.oddCount(Arrays.asList("3", "11111111" )).equals(Arrays.asList("the number of odd elements 1n the str1ng 1 of the 1nput.", "the number of odd elements 8n the str8ng 8 of the 8nput." )),
                s.oddCount(Arrays.asList("271", "137", "314" )).equals(Arrays.asList(
                        "the number of odd elements 2n the str2ng 2 of the 2nput.",
                        "the number of odd elements 3n the str3ng 3 of the 3nput.",
                        "the number of odd elements 2n the str2ng 2 of the 2nput."
                ))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}