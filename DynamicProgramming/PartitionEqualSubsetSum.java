/** brute force - Time Limit Exceeded
 * time complexity: O(2 ^ n) exponential
 * space complexity: O(n)
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        
        return recursion(nums, 0, sum / 2);
    }
    
    private boolean recursion(int[] nums, int index, int sum) {
        
        // base case
        if (sum == 0) return true;
        if (sum < 0 || index == nums.length) return false;
        
        // don't pick the item at index or pick it, whichever gets the target sum to ZERO
        return recursion(nums, index + 1, sum) ||
               recursion(nums, index + 1, sum - nums[index]);
    }
}
// =================================================
/** dynamic programming with memoization
 * time complexity: O(m.n) - n be the number of array elements and m be the sum
 * space complexity: O(n)
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        
        // if there are a substring with half the amount, it means it is possible to 
        // divide the target sum, into 2 equal size substrings
        return recursion(nums, 0, sum / 2, new HashMap<String, Boolean>());
    }
    
    private boolean recursion(int[] nums, int index, int sum, Map<String, Boolean> memo) {
        
        // check the memo table
        if (memo.containsKey(index + "," + sum)) {
            return memo.get(index + "," + sum);
        }
        
        // base case
        if (sum == 0) return true;
        if (sum < 0 || index == nums.length) return false;
        
        
        // don't pick the item at index or pick it, whichever gets the target sum to ZERO
        boolean result =  recursion(nums, index + 1, sum, memo) ||
                          recursion(nums, index + 1, sum - nums[index], memo);
        
        memo.put(index + "," + sum, result);
        return result;
    }
}

// =================================================
/**
 * Tabulation
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        
        int sum = totalSum / 2;
        int n = nums.length;
        
        boolean dp[][] = new boolean[n + 1][sum + 1];
        
        // index 0 has no number, so it is not possible to create sum
        for (int j = 0; j <= sum; j++) dp[n][j] = false;
        // sum of zero always possible to make
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        
        for (int i = 1; i <= n; i++) {  // index - rows
            int curr = nums[i - 1];
            for (int j = 0; j <= sum; j++) {    // sum - cols
                if (j < curr)   // not pick this index, skip
                    dp[i][j] = dp[i - 1][j];
                else    // pick it or not
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
            }
        }
        return dp[n][sum];
    }
}