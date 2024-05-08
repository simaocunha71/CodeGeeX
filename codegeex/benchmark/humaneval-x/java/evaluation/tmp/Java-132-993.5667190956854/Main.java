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
        if (string.length() == 0 || string.charAt(0) != '[') return false; // not a valid input
        
        if (string.contains("[]")) return false; // not allowed to have nested brackets
        if (!string.contains("[")) return false; // not allowed to have only empty brackets
        
        HashSet<String> valid = new HashSet<>(); 
        for(int i=0;i<string.length();++i){ // walk through the string, looking for nested brackets
            boolean[] bracket = new boolean[1];
            char ch = string.charAt(i);
            
            if (ch == '[' && !valid.contains("[")) {// if we see [ and haven't seen ] yet, then add to valid
                bracket[0] = true; // set the boolean flag that says we should check next time for a matching ], but only if it hasn't been checked yet
                
                i++; 
            } else { // not a new beginning of a subsequence so just keep checking
                valid.add(validated(i, ch));// check if []
                bracket[0] = false; 
            }
            
        }
        
        return valid.contains("[]"); // nested brackets exist -> true, else false
    }
    
    private String validated(int index, char val){
        String tmp = "";
        
        for (int i=index+1;i<string.length();++i) {
            if (val ==

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