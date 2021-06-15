/**
 * time : O(32) - O(1)
 * space: O(1)
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        
        // check each of 32 bits
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            // shift mask to left by one
            mask = mask << 1;
        }
        return count;
    }
}