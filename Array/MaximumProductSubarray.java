/**
 * dynamic programming
 * time : O(n)
 */
class Solution {
    public int maxProduct(int[] nums) {
        
        if (nums.length == 0) return 0;
       
        // because of Negative numbers, we have to keep curMin, in case we see another negative number and table turns
        int result = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
       
            int temp1 = curMax * nums[i];
            int temp2 = curMin * nums[i];
            curMax = Math.max(nums[i], Math.max(temp1, temp2));
            curMin = Math.min(nums[i], Math.min(temp1, temp2));
            result = Math.max(result, curMax);
        }
        
        return result;
        
    }
}