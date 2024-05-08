import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive floating point number, it can be decomposed into
    and integer part (largest integer smaller than given number) and decimals
    (leftover part always smaller than 1).

    Return the decimal part of the number.
    >>> truncateNumber(3.5)
    0.5
     */
    public double truncateNumber(double number) {
        BigDecimal big = new BigDecimal(String.valueOf(number));
        BigDecimal int_part = big.setScale(0, BigDecimal.ROUND_DOWN);
        
        // we need decimal part of the number to be less than 1, so:
        BigDecimal decimalPart = new BigDecimal(int_part).add(BigDecimal.ONE.subtract(new BigDecimal(String.valueOf(number))));
        return decimalPart.doubleValue();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
            s.truncateNumber(3.5) == 0.5,
            Math.abs(s.truncateNumber(1.33) - 0.33) < 1e-6,
            Math.abs(s.truncateNumber(123.456) - 0.456) < 1e-6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}