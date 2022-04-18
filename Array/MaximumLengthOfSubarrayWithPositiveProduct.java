// anything we hit a zero, we start from begining
// count number of negatives and when even update the max
class Solution {
    public int getMaxLen(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            
            // prune, if the max is bigger than what is left in the array
            if (max >= nums.length - i) {
                return max;
            }
            
            // hit a zero
            if (nums[i] == 0) continue;
            
            int negatives = (nums[i] < 0) ? 1 : 0;
            max = Math.max(max, (nums[i] > 0) ? 1 : 0);
        
            for (int j = i + 1; j < nums.length; j++) {
                
                if (nums[j] < 0) {
                    negatives++;
                // hit a zero
                } else if (nums[j] == 0) {
                    break;
                }
                
                // even negative number
                if (negatives % 2 == 0) {
                    max = Math.max(max, j - i + 1);
                }
                
            }
        }
        
        return max;
    }
}