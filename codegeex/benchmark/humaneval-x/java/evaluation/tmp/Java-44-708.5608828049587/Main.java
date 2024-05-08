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
        if (x == 0 || base < 1 || base > 9) throw new IllegalArgumentException();
        
        // convert it to string representation. and check its length
        String val = Integer.toString(x);
        String str = "";
        for (int i = 0; i < val.length(); i++) {
            if ((i % base == 0) && (val.charAt(i) != '0')) {
                // we should check with (i%base) here to avoid 0x, it is not a digit
                str = str + "1";
            } else if (val.charAt(i) != '0') {
                str += val.charAt(i);
            }
        }
        
        // check the length of string
        if (str.length() == 1 && str.charAt(0) == '1' ) throw new IllegalArgumentException();
        return str;
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