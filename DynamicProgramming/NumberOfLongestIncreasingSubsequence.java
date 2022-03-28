// https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/835323/Python-3-or-DP-or-Explanation
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        // end
        for (int i = 1; i < nums.length; i++) {
            // start
            for (int j = 0; j < i; j++) {
                
                if (nums[i] > nums[j]) {
                    
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                    
                }
                
                // keep max subseuence length updated
                max = Math.max(max, dp[i]);
            }
        }
        
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        
        return res;
    }
}