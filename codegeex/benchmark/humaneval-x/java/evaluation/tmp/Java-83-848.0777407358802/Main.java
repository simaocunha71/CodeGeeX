import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer n, return the count of the numbers of n-digit
    positive integers that start or end with 1.
     */
    public int startsOneEnds(int n) {
        if (n < 2 || n > 9) return 0;
        long[][] counts = new long[10][3];
        
        counts[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            if ((i % 2 == 0 && counts[2][1] != counts[2][0]) ||
                (i % 2 != 0 && counts[2][0] > counts[2][1]))
                    counts[2][counts[2][0] + 1]++;
            if ((i % 10 == 1 && counts[3][2] != counts[3][0]) ||
                (i % 10 != 1 && counts[3][0] > counts[3][2]))
                    counts[3][counts[3][0] + 1]++;
            if ((i % 5 == 1 && counts[4][3] != counts[4][0]) ||
                (i % 5 != 1 && counts[4][0] > counts[4][3]))
                    counts[4][counts[4][0] + 1]++;
            if ((i % 3 == 1 && counts[5][4] != counts[5][0]) ||
                (i % 3 != 1 && counts[5][0] > counts[5][4]))
                    counts[5][counts[5][0] + 1]++;
            if ((i % 2 == 1 && counts[6][5] != counts[6][0]) ||
                (i % 2 != 1 && counts[6][0] > counts[6][5]))
                    counts[6][counts[6][0] + 1]++;
            if ((i % 4 == 1 && counts[7][6] != counts[7][0]) ||
                (i % 4 !=

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.startsOneEnds(1) == 1,
                s.startsOneEnds(2) == 18,
                s.startsOneEnds(3) == 180,
                s.startsOneEnds(4) == 1800,
                s.startsOneEnds(5) == 18000
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}