class Solution {
    public double myPow(double x, int n) {
        double res = helper(x, Math.abs(n));
        
        // if n is negative, upside the result
        return (n <= 0) ? 1 / res : res;
    }
    
    private double helper(double x, int n) {
         
        if (n == 0) return 1;
        if (x == 0) return 0;
        
        double res = helper(x, n / 2);
        res = res * res;
        
        // if n is odd, we need to multiply one extra x
        return (n % 2 == 0) ? res : res * x; 
    }
}