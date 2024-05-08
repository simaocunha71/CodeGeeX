import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function that takes a string as input which contains only square brackets.
    The function should return true if and only if there is a valid subsequence of brackets
    where at least one bracket in the subsequence is nested.

    isNested("[[]]") -> true
    isNested("[]]]]]]][[[[[]") -> false
    isNested("[][]") -> false
    isNested("[]") -> false
    isNested("[[][]]") -> true
    isNested("[[]][[") -> true
     */
    public boolean isNested(String string) {
        if (string.length() == 0 || string.charAt(0) == '(' || string.charAt(0) == '[' || string.charAt(0) == '{') {return false;} // not valid
        int start = 1; // start at second position of the string
        while (start < string.length() && !StringHelper.isNumeric(string.charAt(start))) {// if not a number or an underscore, exit out
            start++;
        }
        int endOfParen = 0; // index of last close paren/bracket
        while (endOfParen < string.length() && !StringHelper.isNumeric(string.charAt(endOfParen))) {// if not a number or an underscore, exit out
            endOfParen++;
        }
        // check if nested is true
        boolean nested = false;
        while (start < string.length() - 1 && !nested) {// if the character at start is in brackets AND it has not been closed yet and the next char isn't a close char, then increment endOfParen by one and check again on nested
            for(int i = start;i <= endOfParen - 2 ; i++) {//for each iteration of this condition, check if the character is nested
                String substring = string.substring(i, i + 1); //get substring from i to i + 1
                nested |= substring.contains(']') || substring.contains('}');
            }
           

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isNested("[[]]" ),
                !s.isNested("[]]]]]]][[[[[]" ),
                !s.isNested("[][]" ),
                !s.isNested("[]" ),
                s.isNested("[[[[]]]]" ),
                !s.isNested("[]]]]]]]]]]" ),
                s.isNested("[][][[]]" ),
                !s.isNested("[[]" ),
                !s.isNested("[]]" ),
                s.isNested("[[]][[" ),
                s.isNested("[[][]]" ),
                !s.isNested("" ),
                !s.isNested("[[[[[[[[" ),
                !s.isNested("]]]]]]]]" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}