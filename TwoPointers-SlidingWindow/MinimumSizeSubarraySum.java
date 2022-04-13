class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int shortest = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                shortest = Math.min(shortest, right - left + 1);
                // close the window from the left
                sum -= nums[left];
                left++;
            } 
            
        }
        
        return shortest == Integer.MAX_VALUE ? 0 : shortest;
    }
}