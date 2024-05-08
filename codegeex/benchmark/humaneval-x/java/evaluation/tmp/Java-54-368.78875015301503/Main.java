import java.util.*;
import java.lang.*;

class Solution {
    /**
    Check if two words have the same characters.
    >>> sameChars("eabcdzzzz", "dddzzzzzzzddeddabc")
    true
    >>> sameChars("abcd", "dddddddabc")
    true
    >>> sameChars("dddddddabc", "abcd")
    true
    >>> sameChars("eabcd", "dddddddabc")
    false
    >>> sameChars("abcd", "dddddddabce")
    false
    >>> sameChars("eabcdzzzz", "dddzzzzzzzddddabc")
    false
     */
    public boolean sameChars(String s0, String s1) {
        if (s0 == null || s1 == null) return false;
        for (int i=0;i<s0.length();i++) if (!s0.charAt(i)==(char)0)return false;
        for (int j=0;j<s1.length();j++) if (!s1.charAt(j)==(char)0)return false;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sameChars("eabcdzzzz", "dddzzzzzzzddeddabc"),
                s.sameChars("abcd", "dddddddabc"),
                s.sameChars("dddddddabc", "abcd"),
                !s.sameChars("eabcd", "dddddddabc"),
                !s.sameChars("abcd", "dddddddabcf"),
                !s.sameChars("eabcdzzzz", "dddzzzzzzzddddabc"),
                !s.sameChars("aabb", "aaccc")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}