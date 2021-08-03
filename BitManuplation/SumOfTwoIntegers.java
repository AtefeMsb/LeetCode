class Solution {
    public int getSum(int a, int b) {
        
        while (b != 0) {
            // 1. calculate the carry
            int c = a & b;
            // 2. simulate the sum without carry
            a = a ^ b;
            // 3. shift the carry 1 to the right, because carry always gets added to the left elements
            b = c << 1;
        }
        
        return a;
    }
}