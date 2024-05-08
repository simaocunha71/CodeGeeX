import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given two intervals,
    where each interval is a pair of integers. For example, interval = (start, end) = (1, 2).
    The given intervals are closed which means that the interval (start, end)
    includes both start and end.
    For each given interval, it is assumed that its start is less or equal its end.
    Your task is to determine whether the length of intersection of these two
    intervals is a prime number.
    Example, the intersection of the intervals (1, 3), (2, 4) is (2, 3)
    which its length is 1, which not a prime number.
    If the length of the intersection is a prime number, return "YES",
    otherwise, return "NO".
    If the two intervals don't intersect, return "NO".


    [input/output] samples:
    intersection((1, 2), (2, 3)) ==> "NO"
    intersection((-1, 1), (0, 4)) ==> "NO"
    intersection((-3, -1), (-5, 5)) ==> "YES"
     */
    public String intersection(List<Integer> interval1, List<Integer> interval2) {
        if (!isPrime(interval1.get(0))) { // check primality of the first element in the left interval
            return "NO";  // then it is not an intersected prime number
        } else {
            int a = interval1.get(0);  // store the starting element of the left subarray into variable 'a'
            for (int i = 1; i < interval2.size(); ++i) {// loop until end of the right array is reached
                if (!(isPrime(interval2.get(i)) && a == interval2.get(0))) { // check primality of the 'a' element from the left subarray and the current prime number in the right subarray
                    return "NO";  // then it is not an intersected prime number
                } else {// if both are primes, store them into two variables
                   int temp = interval2.get(i);

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.intersection(Arrays.asList(1, 2), Arrays.asList(2, 3)), "NO" ),
                Objects.equals(s.intersection(Arrays.asList(-1, 1), Arrays.asList(0, 4)), "NO" ),
                Objects.equals(s.intersection(Arrays.asList(-3, -1), Arrays.asList(-5, 5)), "YES" ),
                Objects.equals(s.intersection(Arrays.asList(-2, 2), Arrays.asList(-4, 0)), "YES" ),
                Objects.equals(s.intersection(Arrays.asList(-11, 2), Arrays.asList(-1, -1)), "NO" ),
                Objects.equals(s.intersection(Arrays.asList(1, 2), Arrays.asList(3, 5)), "NO" ),
                Objects.equals(s.intersection(Arrays.asList(1, 2), Arrays.asList(1, 2)), "NO" ),
                Objects.equals(s.intersection(Arrays.asList(-2, -2), Arrays.asList(-3, -2)), "NO" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}