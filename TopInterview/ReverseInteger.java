package TopInterview;

public class ReverseInteger {
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
}