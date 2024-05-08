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
        if (lst.size() < 2) return "No"; // If at least one of the strings is empty we can't make a result string with good balance
        for (int i = 0; i < lst.size(); ++i) {
            String temp = lst.get(i);
            char last = temp.charAt((temp.length() - 1));
            if (last == '(') {
                String result = "";
                for (int j = 0; j < lst.size(); ++j) {
                    String current = lst.get(j);
                    char lastInCurrent = current.charAt((current.length() - 1));
                    if (lastInCurrent == '(' && !result.isEmpty()) { // If we have reached the end of the string and it's still not balanced, return No
                        return "No";
                    } else { // Otherwise set the balance to the next string and add it to result
                        if (current.endsWith(")") && !result.isEmpty())
                            continue;
                        String newBalance = result + current;
                        result = newBalance; // Update the next one
                    }
                }
                return "Yes";
            } else { // When last is not '(', this means

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