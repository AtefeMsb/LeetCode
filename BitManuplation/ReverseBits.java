public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int result = 0;
        // for each bit from right side
        for (int i = 0; i < 32; i++) {
            // shift the result 1 to the left, to add zero to the right
            result = result << 1;
            // if the last bit is one, add one to the result
            if ((n & 1) == 1) {
                result++;
            }
            // shift n to the right, to remove the most right bit (last bit)
            n = n >> 1;
        }
        
        return result;
    }
}