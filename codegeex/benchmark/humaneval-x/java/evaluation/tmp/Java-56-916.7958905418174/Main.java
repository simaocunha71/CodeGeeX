import java.util.*;
import java.lang.*;

class Solution {
    /**
    brackets is a string of "<" and ">".
    return True if every opening bracket has a corresponding closing bracket.
    
    >>> correctBracketing("<")
    false
    >>> correctBracketing("<>")
    true
    >>> correctBracketing("<<><>>")
    true
    >>> correctBracketing("><<>")
    false
     */
    public boolean correctBracketing(String brackets) {
        if (brackets.length() == 0 || brackets.charAt(0) != '[' && brackets.charAt(0) != ']'){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0, j = brackets.length(); i < j; i++){
            if(brackets.charAt(i) == '['){
                if (!stack.isEmpty()){
                    if (stack.peek() != ']' || !(stack.peek()+1).equals("]")){
                        return false;
                    }
                } else {
                    stack.push('[');
                }
            }else{
                if (!stack.isEmpty()){
                    if (stack.pop() != '['){
                        return false;
                    }
                }
                if(!(brackets.charAt(i) + 1).equals("]")){
                    return false;
                }
            }
        }
        
        int index = j - 1;
        while (index >= 0){
            if ((brackets.charAt(index) == '[' && !stack.isEmpty()) || brackets.charAt(index-1) != "]"){
                return false;
            }else {
                char t = stack.pop();
                index--;
                if (t!="[" || !((i+1)<brackets.length() && brackets.charAt(i+1)=='[')){
                    return false;
                } 
            }
        }
        
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.correctBracketing("<>"),
                s.correctBracketing("<<><>>"),
                s.correctBracketing("<><><<><>><>"),
                s.correctBracketing("<><><<<><><>><>><<><><<>>>"),
                !s.correctBracketing("<<<><>>>>"),
                !s.correctBracketing("><<>"),
                !s.correctBracketing("<"),
                !s.correctBracketing("<<<<"),
                !s.correctBracketing(">"),
                !s.correctBracketing("<<>"),
                !s.correctBracketing("<><><<><>><>><<>"),
                !s.correctBracketing("<><><<><>><>>><>")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}