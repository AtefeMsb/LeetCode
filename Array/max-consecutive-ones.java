/*
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int max = 0;
        int currentMax = 0;
        
        for (int num : nums) {
            if (num == 0) {
                if (currentMax > max) {
                    // save so far count
                    max = currentMax;
                }
                // start a new counter
                currentMax = 0;;
                continue;
            }
            
            // num == 1
            currentMax++;
        }
        
        return Math.max(max, currentMax);
    }
    
}

*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxLength = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == 1) {
                currentLength += 1;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;  
            }
        }
        
        return maxLength;
    }
}