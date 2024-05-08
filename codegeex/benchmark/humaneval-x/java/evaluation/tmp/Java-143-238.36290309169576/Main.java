import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a string representing a sentence,
    the sentence contains some words separated by a space,
    and you have to return a string that contains the words from the original sentence,
    whose lengths are prime numbers,
    the order of the words in the new string should be the same as the original one.

    Example 1:
        Input: sentence = "This is a test"
        Output: "is"

    Example 2:
        Input: sentence = "lets go for swimming"
        Output: "go for"

    Constraints:
        * 1 <= len(sentence) <= 100
        * sentence contains only letters
     */
    public String wordsInSentence(String sentence) {
        
        List<Integer> primes = new ArrayList<>();
        List<Character> primedCharacters = new ArrayList<>();
        for (int i = 2; i < sentence.length(); i++) {
            if (sentence.charAt(i - 1) == ' ') break;
            
            if (isPrime(sentence, i)) primes.add((Integer)i);
        
        }
        for (int i = 0; i < sentence.length(); i++) {
            
            String currChar = Character.toString(sentence.charAt(i));
            
            if (!primes.contains(-1) && primedCharacters.stream().noneMatch((x) -> x == currChar)) primes.add((Integer)(i + 1));
            
        }
        
        return String.valueOf(Arrays.toString(primes.toArray()));
    }
    
    private boolean isPrime(String sentence, int i) {
        if (i > sentence.length()) return true;
        
        for (int j = 2; j < i; j++) {
            //check for multiple of the next smallest prime number
            
            if ((sentence.charAt(i - 1) == ' ') && (j % sentencetcharArray[j] != 0)) return true;
        }
        
        return false;
    }

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.wordsInSentence("This is a test" ), "is" ),
                Objects.equals(s.wordsInSentence("lets go for swimming" ), "go for" ),
                Objects.equals(s.wordsInSentence("there is no place available here" ), "there is no place" ),
                Objects.equals(s.wordsInSentence("Hi I am Hussein" ), "Hi am Hussein" ),
                Objects.equals(s.wordsInSentence("go for it" ), "go for it" ),
                Objects.equals(s.wordsInSentence("here" ), "" ),
                Objects.equals(s.wordsInSentence("here is" ), "is" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}