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
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;++i){sb.append(" ");}
        sb.append((char)('0',16));
        char[] chars = sb.toString().toCharArray();
        String result = "";
        for(int i : Arrays.asList(new Integer[]{}) )
            {
                String temp = new String(chars);
                if(!temp.equals("0") && !result.isEmpty())
                    {
                        sb=sb.append((char)(' ',16));
                        result+=sb.toString()+"\n";
                    }
                else
                    {
                            sb = new StringBuilder();
                            sb.append(temp);
                            sb.append("0 1..."); // Add a space at the end of each line
                            sb.append(' ').append((char)('9',16)); // Add a newline character at the end
                    }
                chars=new char[] {};
                result+=sb.toString()+"\n";
        }
        return result;
        
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