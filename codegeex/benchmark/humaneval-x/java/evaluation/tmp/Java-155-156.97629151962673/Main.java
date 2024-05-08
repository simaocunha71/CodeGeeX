import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given an integer. return a tuple that has the number of even and odd digits respectively.
    
     Example:
        evenOddCount(-12) ==> (1, 1)
        evenOddCount(123) ==> (1, 2)
     */
    public List<Integer> evenOddCount(int num) {
        
        ArrayList<Integer> result = new ArrayList<>();
        String digits = "";
        while (num > 0){
            digits += Character.valueOf((char)(num % 10 + '0'));
            num /= 10;
        }
        if(digits.length() == 1) {
           result.add(1);
         return result;
         } else {
             int even = 0, odd = 0;
            for (int i = 0; i < digits.length();i++){
                if(Character.valueOf((char)(digits.charAt(i))).equals('2')){
                    even++;
                } else {
                    odd++;
                }
            }
         return result;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.evenOddCount(7).equals(Arrays.asList(0, 1)),
                s.evenOddCount(-78).equals(Arrays.asList(1, 1)),
                s.evenOddCount(3452).equals(Arrays.asList(2, 2)),
                s.evenOddCount(346211).equals(Arrays.asList(3, 3)),
                s.evenOddCount(-345821).equals(Arrays.asList(3, 3)),
                s.evenOddCount(-2).equals(Arrays.asList(1, 0)),
                s.evenOddCount(-45347).equals(Arrays.asList(2, 3)),
                s.evenOddCount(0).equals(Arrays.asList(1, 0))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}