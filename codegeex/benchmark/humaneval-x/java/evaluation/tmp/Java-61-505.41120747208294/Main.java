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
        if (brackets.length() == 0) return true;
         Set<String> bracketsSet = new HashSet<>();
         for(int i=0,j=0;i<=brackets.length();i++){
             char c = brackets.charAt(i);
             switch(c){
                 case ')':{
                     if(!bracketIsClosing(i+1)){
                         return false;
                     }
                     j++;
                     bracketsSet.add(String.valueOf(j));
                 }break;
             }
         }
         return bracketsSet.size()==j;
    }
    private boolean bracketIsClosing(int idx){
        for(int i=0;i<idx-1;i++){
            char c = brackets.charAt(i);
            if(!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) return true;
        }
        return false;
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