import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string s, count the number of uppercase vowels in even indices.
    
    For example:
    countUpper("aBCdEf") returns 1
    countUpper("abcdefg") returns 0
    countUpper("dBBE") returns 0
     */    
    public int countUpper(String s) {
        if (s == null || s.length() == 0) return 0;
        char firstChar = s.charAt(0);
        if (firstChar <= 'Z') firstChar +=26; // change to upper case
        
        int count = 1;
        for (int i=0; i<s.length(); ++i) {
            if (isUpper(s.charAt(i))) {
                if ((i % 2 == 0)) count++;
            } else {
                break;
            }
        }
        
        return count;
    }
    static boolean isUpper(char ch) {
        if (ch >= 'a' && ch <= 'z') return false;
        if (ch > 'Z') return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.countUpper("aBCdEf")  == 1,
                s.countUpper("abcdefg") == 0,
                s.countUpper("dBBE") == 0,
                s.countUpper("B")  == 0,
                s.countUpper("U")  == 1,
                s.countUpper("") == 0,
                s.countUpper("EEEE") == 2
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}