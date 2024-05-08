import java.util.*;
import java.lang.*;

class Solution {
    /**
    Evaluate whether the given number n can be written as the sum of exactly 4 positive even numbers
    Example
    isEqualToSumEven(4) == false
    isEqualToSumEven(6) == false
    isEqualToSumEven(8) == true
     */
    public boolean isEqualToSumEven(int n) {
        //write your code here
        if (n%2!=0||n>=4) return false;
        int min=1,max=-1,sum=0,sum_even=0;
        
        for (int i = 0; i <= Math.min(Math.abs((double) n/3), 10); i++) {
            if (i*i==n || ((i+1)*(i+1))==n && min>i) {
                sum+=2*(i-min)+(i*i-(int)(i*i));
                sum_even=sum%2;
                
                if (sum_even==0&&min<max) {
                    max++;
                } 
                else if (sum_even==1&&min>max) {
                    min++;
                } 
            }
        }
        
        return sum==4;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isEqualToSumEven(4) == false,
                s.isEqualToSumEven(6) == false,
                s.isEqualToSumEven(8) == true,
                s.isEqualToSumEven(10) == true,
                s.isEqualToSumEven(11) == false,
                s.isEqualToSumEven(12) == true,
                s.isEqualToSumEven(13) == false,
                s.isEqualToSumEven(16) == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}