import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer N, return the total sum of its digits in binary.

    Example
        For N = 1000, the sum of digits will be 1 the output should be "1".
        For N = 150, the sum of digits will be 6 the output should be "110".
        For N = 147, the sum of digits will be 12 the output should be "1100".

    Variables:
        @N integer
             Constraints: 0 <= N <= 10000.
    Output:
         a string of binary number
     */
    public String solve(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 32; i <= 32 + N; i += 4) {//31~32, 32~33 ...32+N
            int sum = 0;
            String digits[] = Integer.toHexString(i).toUpperCase().toString();
            for (int j = 0; j < digits.length(); j++) {
                sb.append(digits[j]);
                sum += Character.getNumericValue(digits[j]);// 1~9, A~F=10~15
            }
            sb.setLength(sb.length() - 1);// remove last char which is a space
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.solve(1000), "1"),
                Objects.equals(s.solve(150), "110"),
                Objects.equals(s.solve(147), "1100"),
                Objects.equals(s.solve(333), "1001"),
                Objects.equals(s.solve(963), "10010")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}