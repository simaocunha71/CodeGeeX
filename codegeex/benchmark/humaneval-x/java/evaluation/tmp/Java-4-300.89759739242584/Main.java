import java.util.*;
import java.lang.*;

class Solution {
    /**
    For a given list of input numbers, calculate Mean Absolute Deviation
    around the mean of this dataset.
    Mean Absolute Deviation is the average absolute difference between each
    element and a centerpoint (mean in this case):
    MAD = average | x - x_mean |
    >>> meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0))
    1.0
     */
    public double meanAbsoluteDeviation(List<Double> numbers) {
        // if list is empty, return 0;
        // otherwise -1.0 because the sum of these numbers will be negative at some point (and we will never get to that point), and a mean absolute deviation can't be negative
        double mean = calculateMean(numbers);
        // then check if the average is positive or not, so we don't divide by -1.0 here later...
        return Math.abs((mean + 25.0) / (numbers.size() * 3));
    }
    private static double calculateMean(List<Double> numbers) {
        // check if list is empty, and don't divide by -1.0 here later...
        return Math.abs((numbers.stream().mapToInt(n -> n).sum() + 25.0f) / (numbers.size() * 3));
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0))) - 2.0/3.0) < 1e-6,
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0))) - 1.0) < 1e-6,
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))) - 6.0/5.0) < 1e-6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}