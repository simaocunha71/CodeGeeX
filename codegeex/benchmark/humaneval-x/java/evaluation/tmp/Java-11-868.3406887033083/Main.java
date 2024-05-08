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
        int x = 0;
        int y = 0;
        
        while (a.length() > 0 && b.length()>0){
            //If last digit of a or b is 1 then do XOR with next digit
            if(a.charAt(a.length()-1)=='1'){
                x^=a.charAt(a.length()-1);
                a = a.substring(0,a.length()-1);
            } else {
                y^=b.charAt(b.length()-1);
                b = b.substring(0,b.length()-1);
            }
        }
        
        //if last digit of both strings is 1 then XOR with xor
        if((a.length()==0 && b.length()==0)||(a.charAt(a.length()-1)=='1') || (b.charAt(b.length()-1)=='1')){
            return String.valueOf((x%2).toString());
        } else {
            if(a.length()>0 && b.length() == 0){
                y = x;
            } else if (b.length() > 0 && a.length()==0){
                x = y;
            }
            
            return String.valueOf((x*2 + y)%4).toString();
        }
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