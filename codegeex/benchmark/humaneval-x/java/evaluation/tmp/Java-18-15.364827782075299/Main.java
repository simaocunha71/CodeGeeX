import java.util.*;
import java.lang.*;

class Solution {
    /**
    Find how many times a given substring can be found in the original string. Count overlaping cases.
    >>> howManyTimes("", "a")
    0
    >>> howManyTimes("aaa", "a")
    3
    >>> howManyTimes("aaaa", "aa")
    3
     */
    public int howManyTimes(String string, String substring) {
        if (string == null || substring.length() == 0) return 0; // Base case
        
        HashMap<Character, Integer> letters = new HashMap<>();
        Set<Character> s = string.toLowerCase().letters();
        for(int i=0;i<s.size();i++){
            char ch = s.elementAt(i);
            if (!letters.containsKey(ch)){
                letters.put(ch, 0);
            }
            letters.put(ch, letters.get(ch)+1);
        }
        
        HashMap<String, Integer> strings = new HashMap<>();
        for (int i=0;i<=substring.length();i++){
            char ch = substring.charAt(i);
            if (!letters.containsKey(ch)){ // not found
                continue;
            }
            
            String s1 = string.toLowerCase().substring(0, i+1);
            int count = letters.get(ch);
            strings.put(s1+substring, count);
        }
        
        int res = 0;
        for (Map.Entry<String,Integer> entry: strings.entrySet()){
            if (entry.getValue() != 0 && !entry.getKey().equals("")){ // substring found
                Integer n = howManyTimes(string.substring(0, string.length()-entry.getKey().length()), substring);
                res+=n;
            }
        }        
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.howManyTimes("", "x") == 0,
                s.howManyTimes("xyxyxyx", "x") == 4,
                s.howManyTimes("cacacacac", "cac") == 4,
                s.howManyTimes("john doe", "john") == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}