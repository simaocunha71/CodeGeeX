import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given 2 words. You need to return true if the second word or any of its rotations is a substring in the first word
    cycpatternCheck("abcd","abd") => false
    cycpatternCheck("hello","ell") => true
    cycpatternCheck("whassup","psus") => false
    cycpatternCheck("abab","baa") => true
    cycpatternCheck("efef","eeff") => false
    cycpatternCheck("himenss","simen") => true
     */
    public boolean cycpatternCheck(String a, String b) {
        if (a.length() == 0 || b.length() == 0)
            return false; // No words to check!
         int i = 0 ;
        for (i = 0; i < a.length(); i++)
        {
           char c1 = a.charAt(i);
                char c2 = b.charAt((b.length() - 1));
                    if (c1 == c2) // Found match between a[0] and b[len-1], check for valid substring.
                        break;
        }
       return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.cycpatternCheck("xyzw", "xyw") == false,
                s.cycpatternCheck("yello", "ell") == true,
                s.cycpatternCheck("whattup", "ptut") == false,
                s.cycpatternCheck("efef", "fee") == true,
                s.cycpatternCheck("abab", "aabb") == false,
                s.cycpatternCheck("winemtt", "tinem") == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}