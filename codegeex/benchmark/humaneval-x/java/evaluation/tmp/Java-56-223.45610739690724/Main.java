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
        if (brackets.length() == 0) return true;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (char c : brackets.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) continue;
            
            int index = brackets.indexOf('<', brackets.length() - 1);
            char last = brackets.charAt(brackets.length() - 1), c2 = brackets.charAt(index + 1);
            
            if (c == '<' && queue.size() != 0) {
                int lv = queue.poll().intValue();
                
                char lastChar = brackets.charAt(brackets.length() - lv - 2), c3 = brackets.charAt(bralets.length() - lv - index);
                
                if (c == '>' && lastChar != '>') return false;
                else if (lvl + 1 > queue.size()) {
                    if (!correctBracketing(brackets.substring(index, bralets.length()))) return false;
                }
            }
            
            char c1 = brackets.charAt(0), index2 = brackets.indexOf('>', brackets.length()), lastChar, last = brackets.charAt(bralets.length());
            queue.offer(c1 < Character.compare(lastChar || last == '>', true ? 1 : -1) ? c1: (index2 != Integer.MAX_VALUE ? index2 + Character.compareTo(c2, c2 == '<' || c2 == '(' ? 0 : 1) : index2), new PriorityQueue.PriorityEntry

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