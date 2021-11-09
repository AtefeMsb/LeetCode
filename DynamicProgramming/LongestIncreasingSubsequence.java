/**
 * dynamic programming
 * time: O(n ^ 2)
 * space: O(n)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        // each element can create at least a subsequence of length 1
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            // check each and every elements before it to find optimum answer
            for (int j = 0; j < i; j++) {
                // if can be part of the subsequenec
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        
        // check the whole dp array for maximum
        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
       
        return max;
    }
}

// ------------------------------------------------------
/**
 * memoization
 * time limit error on leetcode
 */

class Solution {
    public int lengthOfLIS(int[] nums) { 
        return memoization(nums, 0, Integer.MIN_VALUE, new HashMap<String, Integer>()); 
    }
    
    public int memoization(int[] nums, int i, int prevValue, Map<String, Integer> memo) {
        
        if (i == nums.length) {
            return 0;
        }
        
        String key = i + "-" + prevValue;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int notTake = memoization(nums, i + 1, prevValue, memo);
        int take = Integer.MIN_VALUE;
        if (nums[i] > prevValue) {
            take = 1 + memoization(nums, i + 1, nums[i], memo);
        }
        
        int result = Math.max(take, notTake);
        memo.put(key, result);
        
        return result;
        
    }
}