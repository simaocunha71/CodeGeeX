import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input are two strings a and b consisting only of 1s and 0s.
    Perform binary XOR on these inputs and return result also as a string.
    >>> stringXor("010", "110")
    "100"
     */
    public String stringXor(String a, String b) {
        int length = Math.min(a.length(), b.length());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = a.charAt(i);
            char d = b.charAt(i);
            
            if ((c & d) == 0)
                res.append("1");
            else
                res.append("0");
        }
        
        return res.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.stringXor("111000", "101010"), "010010"),
                Objects.equals(s.stringXor("1", "1"), "0"),
                Objects.equals(s.stringXor("0101", "0000"), "0101")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}