import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a list of two strings, both strings consist of open
    parentheses "(" or close parentheses ")" only.
    Your job is to check if it is possible to concatenate the two strings in
    some order, that the resulting string will be good.
    A string S is considered to be good if and only if all parentheses in S
    are balanced. For example: the string "(())()" is good, while the string
    "())" is not.
    Return "Yes" if there"s a way to make a good string, and return "No" otherwise.

    Examples:
    matchParens(Arrays.asList("()(", ")")) == "Yes"
    matchParens(Arrays.asList(")", ")")) == "No"
     */
    public String matchParens(List<String> lst) {
        if (lst.size() < 2) return "";
        Deque<Boolean> queue = new ArrayDeque<>();
        for (String s : lst) {
            String stmp = s;
            if (!queue.isEmpty()) {
                boolean isBalanced = true;
                while(!queue.isEmpty()) {
                    String curStr =  queue.removeLast();
                    boolean left = false, right = false;
                    for (int i=0; i<curStr.length()-1;i++) {
                        if(isBalanced && curStr.charAt(i) == '(' && !right) {
                            queue.push(true);
                            left = true;
                        } else if (isBalanced && curStr.charAt(i) == ')' && right) {
                            queue.push(false);
                            right = false;
                        } else if (!isBalanced && !left) {
                           isBalanced=false;
                        }
                    }
                }
                stmp += (isBalanced ? "()" : (right ? ")(" : ")("));
            }
            queue.addLast(stmp.length()%2==0);
        }
       return  ("No" + (queue.isEmpty())

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.matchParens(Arrays.asList("()(", ")")).equals("Yes"),
                s.matchParens(Arrays.asList(")", ")")).equals("No"),
                s.matchParens(Arrays.asList("(()(())", "())())")).equals("No"),
                s.matchParens(Arrays.asList(")())", "(()()(")).equals("Yes"),
                s.matchParens(Arrays.asList("(())))", "(()())((")).equals("Yes"),
                s.matchParens(Arrays.asList("()", "())")).equals("No"),
                s.matchParens(Arrays.asList("(()(", "()))()")).equals("Yes"),
                s.matchParens(Arrays.asList("((((", "((())")).equals("No"),
                s.matchParens(Arrays.asList(")(()", "(()(")).equals("No"),
                s.matchParens(Arrays.asList(")(", ")(")).equals("No")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}