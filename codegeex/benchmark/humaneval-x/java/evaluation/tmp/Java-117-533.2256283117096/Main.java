import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string s and a natural number n, you have been tasked to implement
    a function that returns a list of all words from string s that contain exactly
    n consonants, in order these words appear in the string s.
    If the string s is empty then the function should return an empty list.
    Note: you may assume the input string contains only letters and spaces.
    Examples:
    selectWords("Mary had a little lamb", 4) ==> ["little"]
    selectWords("Mary had a little lamb", 3) ==> ["Mary", "lamb"]
    selectWords("simple white space", 2) ==> []
    selectWords("Hello world", 4) ==> ["world"]
    selectWords("Uncle sam", 3) ==> ["Uncle"]
     */
    public List<String> selectWords(String s, int n) {
        // Your code here
        Set<String> set = new HashSet<>(); 
        
        for (int i = 0; i < s.length();i++){
            if(n > 0 && s.charAt(i)==' ')
                n--;
            
            //Checking for the alphabet, ignoring space character if present
            if((s.charAt(i) >= 'a'&& s.charAt(i) <= 'z')|| (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){
                if(!set.contains(s.substring(0, i+1)))
                    set.add(s.substring(0, i+1));
            }
        } 
        
        //Sorting the words in order
        Collections.sort(set);
    
        List<String> list = new ArrayList<>();
        for (int i=0;i<n && i<list.size();i++) {
            list.remove(0);
        }
        
        return Collections.unmodifiableList(list); 
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.selectWords("Mary had a little lamb", 4).equals(List.of("little" )),
                s.selectWords("Mary had a little lamb", 3).equals(Arrays.asList("Mary", "lamb")),
                s.selectWords("simple white space", 2).equals(List.of()),
                s.selectWords("Hello world", 4).equals(List.of("world" )),
                s.selectWords("Uncle sam", 3).equals(List.of("Uncle" )),
                s.selectWords("", 4).equals(List.of()),
                s.selectWords("a b c d e f", 1).equals(Arrays.asList("b", "c", "d", "f"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}