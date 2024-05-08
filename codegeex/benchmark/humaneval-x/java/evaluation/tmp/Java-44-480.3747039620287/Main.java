import java.util.*;
import java.lang.*;

class Solution {
    /**
    Change numerical base of input number x to base.
    return string representation after the conversion.
    base numbers are less than 10.
    >>> changeBase(8, 3)
    "22"
    >>> changeBase(8, 2)
    "1000"
    >>> changeBase(7, 2)
    "111"
     */
    public String changeBase(int x, int base) {
        if (x < 0 || x > Integer.MAX_VALUE/base) // input range check
            throw new IllegalArgumentException("Base must be less than or equals to the integer type.");
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            if ((x ^ (1 << 8)) == 0) // when x is zero, stop.
                break;
            
            char digit;
            
            // check if the base number of x is 3
            if (base == 3 && (int)(x/base) == 3) { // convert to base 3
                
                sb.append('2');
                x = x - (x/base);
                break;
            } else if ((charsBase[x % base]) != '0') { // check for the given character's existence in charsBase and add it into stringBuilder
                
                digit = digitsToBase.get(charsBase[(int) x%base]); // get the charater as a number. Convert that number to a String so that we can append later on.
                sb.append(digit);
            } else { // not a 3 or character existed in charsBase, so it's already zero. Return if condition is satisfied. Else, continue with the while loop.
                break;
            }
        }
        
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.changeBase(8, 3), "22"),
                Objects.equals(s.changeBase(9, 3), "100"),
                Objects.equals(s.changeBase(234, 2), "11101010"),
                Objects.equals(s.changeBase(16, 2), "10000"),
                Objects.equals(s.changeBase(8, 2), "1000"),
                Objects.equals(s.changeBase(7, 2), "111")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
        for (int x = 2; x < 8; x++) {
            if (!Objects.equals(s.changeBase(x, x + 1), String.valueOf(x))) {
                throw new AssertionError();
            }
        }
    }
}