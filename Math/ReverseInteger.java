class Solution {
    public int reverse(int x) {
        
        // to prevent the integer overflow
        long xReversed = 0;
        boolean negative = false;
        
        if (x < 0) {
            negative = true;
            x = x * -1;
        }
        
        while (x > 0) {
            int remainder = x % 10; 
            x = x / 10;
            
            xReversed = xReversed * 10 + remainder; 
        }
        
        // if reveresed is more than integer limit
        if (xReversed > Integer.MAX_VALUE) {
            return 0;
        }
        
        return negative ? (int)(xReversed * -1) : (int)(xReversed);
        
    }
}// -----------------------------------------------
class Solution {
    public int reverse(int x) {
        
        int xReversed = 0;
        
        while (x != 0) {
            int pop = x % 10;
            int res = xReversed * 10 + pop;
            // if overflow happens, result will not be equal previous one
            if ((res - pop) / 10 != xReversed) {
                return 0;
            }
            xReversed = res;
            x = x / 10;
        }
        
        return xReversed;   
    }
}