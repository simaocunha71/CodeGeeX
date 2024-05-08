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
        if (x == Integer.MIN_VALUE || !(y >= x)) {
            return Integer.MIN_VALUE;
        } else if(x <= 0 && x > y){
            return -1;
        }else{
            int maxEven = y-1, minNums=maxEven*2+1;
            for (int i = x ; i <= maxEven;i++){
                if ((maxEven%2) && i==maxEven){
                    return i;
                }
            }
        }
        
    System.out.println("chooseNum(1, 3) returns "+chooseNum(1, 3));
    System.out.println("chooseNum(-2, -4) returns "+chooseNum(-2,-4));    
        
    return -1;
}
public static void main(String[] args) {
        new Solution().chooseNum(-1000,-1);
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