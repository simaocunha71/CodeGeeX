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
        for (char c : digitToNumMap.get(N)) {
            sb.append(c);
        }
        return sb.toString().replace("1", "0").replace("0", "1");
    }
    
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int N;
         System.out.print("enter the number: ");
         N = scanner.nextInt();
         String ans = Solution.solve(N);
        System.out.println(ans);
    }
    
    private HashMap<Integer,String> digitToNumMap = new HashMap<>();
    
    static {
        digitToNumMap.put(1, "0");
        digitToNumMap.put(2, "1");
        digitToNumMap.put(3, "10");
        digitToNumMap.put(4, "11");
        digitToNumMap.put(5, "110");
        digitToNumMap.put(6, "111");
        digitToNumMap.put(7, "1100");
        digitToNumMap.put(8, "100");
        digitToNumMap.put(9, "101");
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