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
        if (s == null || s.length() < 3) return false;
        char [] cArray = s.toCharArray();
        int count = 1;
        for(int i=0;i<count;i++) {
            String curStr = new String(cArray,i,count);
            if (curStr == null) return false;
            ArrayList<Character> list = new ArrayList<>();
            for(int j=i+1;j<=count-1;j++) {
                Character x = cArray[j];
                list.add(x);
                String str = new String(cArray,i+1,count).toLowerCase();
                if (list.contains(Character.toString(str.charAt(0)))) return false;
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