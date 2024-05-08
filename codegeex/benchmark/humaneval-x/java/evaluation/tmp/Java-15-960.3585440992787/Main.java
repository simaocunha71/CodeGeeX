import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return a string containing space-delimited numbers starting from 0 upto n inclusive.
    >>> stringSequence(0)
    "0"
    >>> stringSequence(5)
    "0 1 2 3 4 5"
     */
    public String stringSequence(int n) {
        //Write your code here
        StringBuilder sb = new StringBuilder();
        
       for (int i=0;i<n ;i++){
           if(sb.length()==0){
               sb.append("0");
            }else{
                sb.append(" ");
            }
           sb.append(i);
        }   
      return sb.toString();
      
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.stringSequence(0).equals("0"),
                s.stringSequence(3).equals("0 1 2 3"),
                s.stringSequence(10).equals("0 1 2 3 4 5 6 7 8 9 10")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}