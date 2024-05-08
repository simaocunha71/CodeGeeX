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
        //Write your code here
        ArrayList<String> result = new ArrayList<String>();;
        String temp;
        List<String> res =  new LinkedList<>();
        //temp = paren_string.replace(") ", "");
         for(int i=0;i<=paren_string.length()-1;i++){// i<=(length(str)-1)
             if(paren_string.charAt(i)!=")"&&paren_string.charAt(i+1)!="("){
                 res.addAll((String[])paren_string.subList(i, i+2).stream().collect(Collectors.toList()));}
             else{
                 temp = paren_string.substring(0, paren_string.length()-1);
                 if(!temp.equals("")){
                     res.addAll((String[])paren_string.subList(i+1, (paren_string).length()).stream().collect(Collectors.toList()));}
             }
         }
        result=res;
        return result;
    }
}

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