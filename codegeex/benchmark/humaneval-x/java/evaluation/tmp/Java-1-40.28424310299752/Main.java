import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input to this function is a string containing multiple groups of nested parentheses. Your goal is to
    separate those group into separate strings and return the list of those.
    Separate groups are balanced (each open brace is properly closed) and not nested within each other
    Ignore any spaces in the input string.
    >>> separateParenGroups("( ) (( )) (( )( ))")
    ["()", "(())", "(()())"]
     */
    public List<String> separateParenGroups(String paren_string) {
        // TODO: Write your code here.
        Set<Character> OPEN = new HashSet<>(Arrays.asList('(', '[', '{', '<'));
        Set<Character> CLOSE = new HashSet<>(Arrays.asList(')', ']', '}', '>'));
        
        List<String> groups = new ArrayList<>();  // create a list that holds all the separated elements
        for (int i=0; i<paren_string.length(); i++){
            if (paren_string.charAt(i)=='(' && !groups.isEmpty()){
                groups.add(new String(paren_string.substring(i, paren_string.indexOf(")", i+1)))); // creates a string for each group
                i = paren_string.indexOf(")", i+1); // moves the index to the end of the last group
            } else if (paren_string.charAt(i)=='(' || !paren_string.isEmpty()){  // check if we have a new group, or its not balanced and move to next index
                groups.add("");    // creates an empty string if there is no group
                
            }else if (CLOSE.contains(paren_string.charAt(i)) && !groups.isEmpty()){   // if a new CLOSE char, we found our last group and close all the groups before it
                int start = i+1;
                while(start>=0 && OPEN.contains(paren_string.charAt(start))){
                    start--;    // move the index down to

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.separateParenGroups("(()()) ((())) () ((())()())").equals(Arrays.asList(
                        "(()())", "((()))", "()", "((())()())"
                )),
                s.separateParenGroups("() (()) ((())) (((())))").equals(Arrays.asList(
                        "()", "(())", "((()))", "(((())))"
                )),
                s.separateParenGroups("(()(())((())))").equals(Arrays.asList(
                        "(()(())((())))"
                )),
                s.separateParenGroups("( ) (( )) (( )( ))").equals(Arrays.asList("()", "(())", "(()())"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}