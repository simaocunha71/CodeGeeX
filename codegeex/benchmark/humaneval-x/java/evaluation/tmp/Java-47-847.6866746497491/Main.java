import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return median of elements in the list l.
    >>> median(Arrays.asList(3, 1, 2, 4, 5))
    3
    >>> median(Arrays.asList(-10, 4, 6, 1000, 10, 20))
    15.0
     */
    public double median(List<Integer> l) {
        if (l == null || l.size() < 3) return Double.NaN;
        return medianForArrays(l);
    }
        
    private static double median(int[] array) {
        int n = array.length;
        Arrays.sort(array);
        if (n % 2 == 0 && n > 2) {
            // Easier case, the data is evenly distributed around the center
            return ((double)n / 2 - 1) * array[n/2] + array[(int)(n/2)];
        } else if (n > 3) {
            int[] leftHalf = Arrays.copyOfRange(array, 0, n/2);
            int[] rightHalf = Arrays.copyOfRange(array, n/2, n);
            
            return medianForArrays(leftHalf) + (n % 2 == 1 ? -1 : 1) * medianForArrays(rightHalf);
        }
        
        throw new IllegalArgumentException("Array is not sorted");
    }
    
    private static double medianForArrays(int[] a) {
        if (a.length == 0) return Double.NaN;
        int mid = (int)(Math.floor((double)a.length / 2)); // ceil throws off by 1, so floor will always be better than Math.round()
        
        // Since we know that the left half is sorted, and it has at least one element, the index of median can be calculated like this:
        //     mid <= (a[mid/2] - a[(mid-1)/2]) / 2
        
        return ((double)a.length / 

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.median(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))) == 3,
                s.median(new ArrayList<>(Arrays.asList(-10, 4, 6, 1000, 10, 20))) == 8.0,
                s.median(new ArrayList<>(Arrays.asList(5))) == 5,
                s.median(new ArrayList<>(Arrays.asList(6, 5))) == 5.5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}