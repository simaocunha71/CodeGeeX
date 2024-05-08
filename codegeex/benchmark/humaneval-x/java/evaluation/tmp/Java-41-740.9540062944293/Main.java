import java.util.*;
import java.lang.*;

class Solution {
    /**
    Imagine a road that's a perfectly straight infinitely long line.
    n cars are driving left to right;  simultaneously, a different set of n cars
    are driving right to left.   The two sets of cars start out being very far from
    each other.  All cars move in the same speed.  Two cars are said to collide
    when a car that's moving left to right hits a car that's moving right to left.
    However, the cars are infinitely sturdy and strong; as a result, they continue moving
    in their trajectory as if they did not collide.

    This function outputs the number of such collisions.
     */
    public int carRaceCollision(int n) {
        // Your code here
        long ans = 0L;
        for (long i=1, j=n-i+1; i<=(n-j); i+=2){
            if ((ans+i)%3!=0||j==1){break;}
            ans+=(i*j);
        }
        return(int)ans/3L;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.carRaceCollision(2) == 4,
                s.carRaceCollision(3) == 9,
                s.carRaceCollision(4) == 16,
                s.carRaceCollision(8) == 64,
                s.carRaceCollision(10) == 100
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}