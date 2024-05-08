import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given two positive integers n and m, and your task is to compute the
    average of the integers from n through m (including n and m).
    Round the answer to the nearest integer and convert that to binary.
    If n is greater than m, return -1.
    Example:
    roundedAvg(1, 5) => "11"
    roundedAvg(7, 5) => -1
    roundedAvg(10, 20) => "1111"
    roundedAvg(20, 33) => "11011"
     */
    public Object roundedAvg(int n, int m) {
        // TODO: Implement this method.
        String[] res=new StringBuilder().append(n).append("").toString();
        for(int i=1;i<m+1;i++){
            res = new StringBuilder().append(res).append((char)(48+(n%i))).append(",").toString(); 
        }
        return res.substring(0, res.length()-1);   
        
        //return "1";
    }
}
public class Solution2 {
	/**
     * 输入: n = 987654321, m = 33
     * 输出: "1001"
        // TODO: Implement this method.
        String[] res=new StringBuilder().append(n).append("").toString();
        for(int i=1;i<m+1;i++){
            res = new StringBuilder().append((char)(65+(n%i))).append(",").toString(); 
        }
        return res.substring(0, res.length()-1);   
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals((String) s.roundedAvg(1, 5), "11" ),
                Objects.equals((String) s.roundedAvg(7, 13), "1010" ),
                Objects.equals((String) s.roundedAvg(964, 977), "1111001011" ),
                Objects.equals((String) s.roundedAvg(996, 997), "1111100101" ),
                Objects.equals((String) s.roundedAvg(560, 851), "1011000010" ),
                Objects.equals((String) s.roundedAvg(185, 546), "101101110" ),
                Objects.equals((String) s.roundedAvg(362, 496), "110101101" ),
                Objects.equals((String) s.roundedAvg(350, 902), "1001110010" ),
                Objects.equals((String) s.roundedAvg(197, 233), "11010111" ),
                (int) s.roundedAvg(7, 5) == -1,
                (int) s.roundedAvg(5, 1) == -1,
                Objects.equals((String) s.roundedAvg(5, 5), "101" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}