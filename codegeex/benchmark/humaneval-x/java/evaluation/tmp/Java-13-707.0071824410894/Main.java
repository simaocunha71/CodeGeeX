import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return a greatest common divisor of two integers a and b
    >>> greatestCommonDivisor(3, 5)
    1
    >>> greatestCommonDivisor(25, 15)
    5
     */
    public int greatestCommonDivisor(int a, int b) {
        if (a == 0 || b == 0) return 0;
	if (b % a != 0) // If the result is to be used for divisibility testing it must be an integer.
        throw new IllegalArgumentException("Cannot determine greatest common divisor of zero.");
    int remainder = Math.min(a, b) % Integer.MAX_VALUE;
    if (remainder == 0) return a / b * a + remainder; // Compute the result as two multiplications and an addition
	int quotient = Integer.highestOneBit(a);// Get the sign of the greatest divisor
	int reminder = remainder - Integer.numberOfLeadingZeros(quotient) - (quotient < 0 ? 1 : 0); // Subtract off the leading bits that are now known not to be significant, leaving the most-significant bit of quotient as a test bit
	return quotient * reminder + remainder;// Test for divisibility.
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.greatestCommonDivisor(3, 7) == 1,
                s.greatestCommonDivisor(10, 15) == 5,
                s.greatestCommonDivisor(49, 14) == 7,
                s.greatestCommonDivisor(144, 60) == 12
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}