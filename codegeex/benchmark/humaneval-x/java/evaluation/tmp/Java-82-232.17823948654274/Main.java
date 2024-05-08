import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a string and returns true if the string
    length is a prime number or false otherwise
    Examples
    primeLength("Hello") == true
    primeLength("abcdcba") == true
    primeLength("kittens") == true
    primeLength("orange") == false
     */
    public boolean primeLength(String string) {
        if (string.length() < 2) return false;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<string.length();i++){
            char chr = string.charAt(i);
            int chrVal = Character.getNumericValue(chr);
            if(!hashMap.containsKey(chrVal)) {
                hashMap.put(chrVal, 1);
            } else{
                hashMap.put(chrVal, ++hashMap.get(chrVal));
            }
        }
        for (int i=2; i<hashMap.size();i++){
            if (hashMap.get(i) == 1){
                return false;
            } else{
                hashMap.put(i, 0);
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.primeLength("Hello") == true,
                s.primeLength("abcdcba") == true,
                s.primeLength("kittens") == true,
                s.primeLength("orange") == false,
                s.primeLength("wow") == true,
                s.primeLength("world") == true,
                s.primeLength("MadaM") == true,
                s.primeLength("Wow") == true,
                s.primeLength("") == false,
                s.primeLength("HI") == true,
                s.primeLength("go") == true,
                s.primeLength("gogo") == false,
                s.primeLength("aaaaaaaaaaaaaaa") == false,
                s.primeLength("Madam") == true,
                s.primeLength("M") == false,
                s.primeLength("0") == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}