import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a string s.
    Your task is to check if the string is happy or not.
    A string is happy if its length is at least 3 and every 3 consecutive letters are distinct
    For example:
    isHappy(a) => false
    isHappy(aa) => false
    isHappy(abcd) => true
    isHappy(aabb) => false
    isHappy(adb) => true
    isHappy(xyy) => false
     */
    public boolean isHappy(String s) {
        if (s.length() < 3) return false;
        Set<Character> charSet = new HashSet<>(Arrays.asList(s.toCharArray()));
        for(int i=0;i<=2;i++){
            Set<Character> subSet = new HashSet<>(charSet);
            if (subSet.size() < 3) return false;
            for(int j=0;j+3<s.length();j++) {
                char c1 = s.charAt(j);
                char c2 = s.charAt(j + 1);
                char c3 = s.charAt(j + 2);
                if (subSet.contains(c1) || subSet.contains(c2) || subSet.contains(c3)) return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isHappy("a"),
                !s.isHappy("aa"),
                s.isHappy("abcd"),
                !s.isHappy("aabb"),
                s.isHappy("adb"),
                !s.isHappy("xyy"),
                s.isHappy("iopaxpoi"),
                !s.isHappy("iopaxioi")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}