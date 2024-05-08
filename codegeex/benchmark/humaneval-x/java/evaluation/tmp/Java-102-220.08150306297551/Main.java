import java.util.*;
import java.lang.*;

class Solution {
    /**
    This function takes two positive numbers x and y and returns the
    biggest even integer number that is in the range [x, y] inclusive. If
    there's no such number, then the function should return -1.
    
    For example:
    chooseNum(12, 15) = 14
    chooseNum(13, 12) = -1
     */
    public int chooseNum(int x, int y) {
        // Your code here
        if (x == 0 || x < 0) return -1;
        
        long startY = y * Math.pow((double)Math.E, (long)Math.log(y));
        long startX = x*Math.pow((double)Math.E,(long)(Math.log(x)+1));
        
        if (startX >= startY) return -1;
        int currentMaxX = 0;
        for (int i=x; i<=y;i++) {
            long sum = Math.pow((double)Math.E, (long)Math.log(i)) * i;
            if (sum >= startY && sum <= startX) {
                currentMaxX = (int)(startX/sum);
            } else continue;
        }
        
        return (int)currentMaxX;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.chooseNum(12, 15) == 14,
                s.chooseNum(13, 12) == -1,
                s.chooseNum(33, 12354) == 12354,
                s.chooseNum(5234, 5233) == -1,
                s.chooseNum(6, 29) == 28,
                s.chooseNum(27, 10) == -1,
                s.chooseNum(7, 7) == -1,
                s.chooseNum(546, 546) == 546
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}