class Solution {
    public int rob(int[] nums) {
        // edge case
        if (nums.length == 1) return nums[0];
        
        int[] part1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] part2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        
        int res1 = helper(part1);
        int res2 = helper(part2);
        
        return Math.max(res1, res2);  
    }
    
    public int helper(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[nums.length - 1];
        
    }
}