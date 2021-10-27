class Solution {
    public int rob(int[] nums) {
        // edge case
        if (nums.length == 1) return nums[0];
        
       // remove the first element
       int[] part1 = Arrays.copyOfRange(nums, 1, nums.length);
       // remove the last element
       int[] part2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        
        int res1 = helper(part1);
        int res2 = helper(part2);
        
        return Math.max(res1, res2);  
    }
    
    public int helper(int[] nums) {
        // edge cases
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
// ---------------------------------------------
class Solution {
    public int rob(int[] nums) {
        // edge case
        if (nums.length == 1) return nums[0];
        
        // remove the first element
        int[] part1 = Arrays.copyOfRange(nums, 1, nums.length);
        // remove the last element
        int[] part2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        
        int res1 = memoization(part1, part1.length - 1, new HashMap<Integer, Integer>());
        int res2 = memoization(part2, part2.length - 1, new HashMap<Integer, Integer>());
        
        return Math.max(res1, res2);  
    }
    
    public int memoization(int[] nums, int start, Map<Integer, Integer> memo) {
        
        if (start < 0) {
            return 0;
        }
        
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        int temp = Math.max(memoization(nums, start - 1, memo), memoization(nums, start - 2, memo) + nums[start]);
        memo.put(start, temp);
        return temp;
    }
}