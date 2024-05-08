import java.util.*;
import java.lang.*;

class Solution {
    /**
    brackets is a string of "(" and ")".
    return True if every opening bracket has a corresponding closing bracket.

    >>> correctBracketing("(")
    false
    >>> correctBracketing("()")
    true
    >>> correctBracketing("(()())")
    true
    >>> correctBracketing(")(()")
    false
     */
    public boolean correctBracketing(String brackets) {
        if (brackets.length() == 0 || brackets.charAt(0) != '(' ) return false;
        int i = -1, j = -2; // -1 for starting at the first character and -2 for backtracking
        boolean[] seen = new boolean[5];
        
        while (++j < brackets.length()) {
            char ch = brackets.charAt(j);
            
            if (ch == ')' && !seen[(int)ch]) return true;
            if (i + 1 >= j && i - 2 > -1 && brackets.charAt(i+1) != ')') {
                seen[ch] = true; // check for duplicate char
            } else {
                seen[(int)ch] = false;
            }
            
            if (ch == '(') i++; // increment open bracket counter
            else if (ch == ')') i--; // decrement close bracket count
        }
        
        return j == 0 && !seen[']'];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.correctBracketing("()"),
                s.correctBracketing("(()())"),
                s.correctBracketing("()()(()())()"),
                s.correctBracketing("()()((()()())())(()()(()))"),
                !s.correctBracketing("((()())))"),
                !s.correctBracketing(")(()"),
                !s.correctBracketing("("),
                !s.correctBracketing("(((("),
                !s.correctBracketing(")"),
                !s.correctBracketing("(()"),
                !s.correctBracketing("()()(()())())(()"),
                !s.correctBracketing("()()(()())()))()")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}