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
        //Write your code here
        if (s == null || n == 0 ){return new ArrayList<>();}
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()){
            if(!Character.isLetter(c)){
                continue;
            }
            else{queue.addLast(c);
             //System.out.println((int)c);
            }
        }
         List<String> words = new ArrayList<>();
        for (int i=0;i<=n;i++){
            if(!queue.isEmpty()){
                Character c = queue.removeFirst();
                int tempInt = (int)c;
                String letter = String.valueOf(tempInt);
                //System.out.println("letter: "+letter+"\n");
                    word = i+1+"-"+letter;
                    if(!word.isEmpty()){
                        words.add(0,word);
                    }else{
                         break;
                    }    
            }} 
          return words;
        
            
        /*for (int i = s.length() - n +1 ;i<s.length();i++){
                if((Character)c == letter

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