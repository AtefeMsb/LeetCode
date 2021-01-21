package recursion;

// Time complexity : O(logn)
// srategy: calculate the half recursively, result will be half * half
class Solution {
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        
        double half = fastPow(x, n / 2);
        
        if (n % 2 == 0) {
            // if n is even
            return half * half;
        } else {
            // if n is odd
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
};;
