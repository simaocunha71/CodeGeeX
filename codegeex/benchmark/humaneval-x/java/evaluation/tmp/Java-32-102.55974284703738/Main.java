import java.util.*;
import java.lang.*;

class Solution {
    /**
    Evaluates polynomial with coefficients xs at point x.
    return xs[0] + xs[1] * x + xs[1] * x^2 + .... xs[n] * x^n
     */
    public double poly(List<Double> xs, double x) {
        double result = 0;
        for (int i = 0; i < xs.size(); i++) {
            result += xs.get(i) * Math.pow(x, i);
        }
        return result;
    }
    
    /**
    xs are coefficients of a polynomial.
    findZero find x such that poly(x) = 0.
    findZero returns only only zero point, even if there are many.
    Moreover, findZero only takes list xs having even number of coefficients
    and largest non zero coefficient as it guarantees
    a solution.
    >>> findZero(Arrays.asList(1, 2)) // f(x) = 1 + 2x
    -0.5
    >>> findZero(Arrays.asList(-6, 11, -6, 1)) // (x - 1) * (x - 2) * (x - 3) = -6 + 11x - 6x^2 + x^3
    1.0
     */
    public double findZero(List<Double> xs) {
        List<Double> coeffs = Arrays.asList(xs); // copy from input list
        if (coeffs.size()%2 != 0 || !(xs.get(xs.size()/2) >= 0)) {
            return -1; // no solution
        
        double x = coeffs.get(coeffs.size()/2); // use as input
        Double prevX = null;
        for (int i = coeffs.size(); i < coeffs.size(); i++) {
            if (!prevX == null) {// start with new x
                prevX = x; // store prevX
            } else {// evaluate poly at prevX
                double res = poly(coeff

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Random rand = new Random(42);
        for (int i = 0; i < 100; i++) {
            int ncoeff = 2 * (rand.nextInt(3) + 1);
            List<Double> coeffs = new ArrayList<>();
            for (int j = 0; j < ncoeff; j++) {
                int coeff = rand.nextInt(20) - 10;
                if (coeff == 0) {
                    coeff = 1;
                }
                coeffs.add((double) coeff);
            }
            double solution = s.findZero(coeffs);
            if (Math.abs(s.poly(coeffs, solution)) > 1e-4) {
                throw new AssertionError();
            }
        }
    }
}