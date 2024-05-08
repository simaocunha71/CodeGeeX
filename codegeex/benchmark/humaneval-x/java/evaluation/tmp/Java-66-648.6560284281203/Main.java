import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a string as input and returns the sum of the upper characters only'
    ASCII codes.

    Examples:
        digitSum("") => 0
        digitSum("abAB") => 131
        digitSum("abcCd") => 67
        digitSum("helloE") => 69
        digitSum("woArBld") => 131
        digitSum("aAaaaXa") => 153
     */
    public int digitSum(String s) {
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // sort alphabets and numbers
        int result = 0;
        for(int i=0;i<s.length();i++){
            if((i+1) < s.length() && (Character.isDigit(chars[i]) || Character.isLowerCase(chars[i]))){ // skip alphabets and numbers
                result += chars[i];
            } else { //skip alpha after the first one and all lower case letters
            	break;
            }
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.digitSum("") == 0,
                s.digitSum("abAB") == 131,
                s.digitSum("abcCd") == 67,
                s.digitSum("helloE") == 69,
                s.digitSum("woArBld") == 131,
                s.digitSum("aAaaaXa") == 153,
                s.digitSum(" How are yOu?") == 151,
                s.digitSum("You arE Very Smart") == 327
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}