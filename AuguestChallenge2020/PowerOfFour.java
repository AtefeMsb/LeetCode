package AuguestChallenge2020;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        
        long i = 1; // 4 ^ 0 = 1
        
        // list all the numbers that are power of 4
        while (i < num) {
            i *= 4;
        }
        
        return i == num;
    }
    
}