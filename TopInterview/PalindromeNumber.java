package TopInterview;

public class PalindromeNumber {
    
    public boolean isPalindrome(int x) {
        
        // use long to handle overflow of integer when reversing
        long xReversed = 0;
        int xCopy = x;

        if (x < 0) return false;
        
        // reverse the x then compare it with x
        while (xCopy > 0) {
            
            int remainder = xCopy % 10;
            xCopy = xCopy / 10;
            xReversed = xReversed * 10 + remainder;
        }
        
        // xReversed = (int)xReversed;
        
        // compare x with xReversed
        return (x == xReversed) ? true : false;
    }    
}