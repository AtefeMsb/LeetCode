/**
 * dynamic programming 2 ways
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        return memo[nums.length];
    }
}

// ---------------------------------
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
// ---------------------------------
// NeetCode way
class Solution {
    public int rob(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;
        
        // [rob1, rob2, num, num+1, num+2, ...]
        for (int num : nums) {
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}
// -----------------------------------------
// memoization
class Solution {
    public int rob(int[] nums) {
        int lastIndex = nums.length - 1;
        return memoization(nums, lastIndex, new HashMap<Integer, Integer>()); 
    }
    
    // top-down approach
    public int memoization(int[] nums, int n, Map<Integer, Integer> memo) {
        
        // base case
        if (n < 0) {
            return 0;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // recurrence relation: pick the biggest either 1: only one house before or 2: current house plus two house before
        int temp = Math.max(memoization(nums, n - 1, memo), memoization(nums, n - 2, memo) + nums[n]);
        memo.put(n, temp);
        return temp;  
    }
}
