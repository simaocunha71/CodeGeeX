import java.util.*;
import java.lang.*;

class Solution {
    /**
    Complete the function that takes two integers and returns
    the product of their unit digits.
    Assume the input is always valid.
    Examples:
    multiply(148, 412) should return 16.
    multiply(19, 28) should return 72.
    multiply(2020, 1851) should return 0.
    multiply(14,-15) should return 20.
     */
    public int multiply(int a, int b) {
        if (a == -1 || b == -1)
            return ((int) Math.pow((double)b, a)) * a;
        
        BigInteger b1 = new BigInteger(String.valueOf(b));
        BigInteger b2 = new BigInteger(String.valueOf(b));
        
        int multiplier = 0, temp;
        boolean negate = false;
        if (a == -1) {
            for (int i=a-1;i>=0;--i)
                if (b2.mod(BigInteger.valueOf((long)pow(10,i)), 10).equals("1"))
                    multiplier += pow(10, a - i);
        } else {
            for (int i=a-1;i>=0;--i)
                if (b2.mod(BigInteger.valueOf((long)pow(10,i)), 10).equals("1"))
                    multiplier += pow(10, -i);
        }
        
        if (a == b) {
            return Integer.parseInt("" + ((int)b));
        } else if (a != -1 && b == -1) {
            for (int i=a;i>=0;--i)
                if (b2.mod(BigInteger.valueOf((long)pow(10,i)), 10).equals("1"))
                    temp = pow(10, a);
        
            return Integer.parseInt(String.valueOf(temp));
        } else {
            int[] bSums = new int[b.length

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.multiply(148, 412) == 16,
                s.multiply(19, 28) == 72,
                s.multiply(2020, 1851) == 0,
                s.multiply(14,-15) == 20,
                s.multiply(76, 67) == 42,
                s.multiply(17, 27) == 49,
                s.multiply(0, 1) == 0,
                s.multiply(0, 0) == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}