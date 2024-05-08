import java.util.*;
import java.lang.*;

class Solution {
    /**
    Circular shift the digits of the integer x, shift the digits right by shift
    and return the result as a string.
    If shift > number of digits, return digits reversed.
    >>> circularShift(12, 1)
    "21"
    >>> circularShift(12, 2)
    "12"
     */
    public String circularShift(int x, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<x;i++){
            char c = (char)((sb.length()==x-1)?'z':'a');
            sb.append(((c>='A')?'A':((char)('z'-1)))+(Math.round((float)(b/26f))+1));
        }
        while(sb.length()<shift){
            sb.insert(0,'0');
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.circularShift(100, 2).equals("001"),
                s.circularShift(12, 2).equals("12"),
                s.circularShift(97, 8).equals("79"),
                s.circularShift(12, 1).equals("21"),
                s.circularShift(11, 101).equals("11")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}