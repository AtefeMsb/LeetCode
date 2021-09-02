/**
 * Memoization - top down approach
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        return memoization(coins, amount, new HashMap<Integer, Integer>());
    }
    
    private int memoization(int[] coins, int amount, Map<Integer, Integer> memo) {
        
        // check the memo table
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        
        // base case
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = memoization(coins, amount - coin, memo);
            if (count == -1) continue;
            min = Math.min(min, count + 1);
        }
        
        int result = min == Integer.MAX_VALUE ?  -1 : min; 
        memo.put(amount, result);
        return result;
    }
}
// =======================================
/**
 * Dynamic Programming
 * time:  O(amount * len(coins))
 * space: O(amount)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (coins.length == 0) return -1;
        
        // sorting the coin array makes the algorithm run faster
        // Arrays.sort(coins);
        
        // amount + 1 is more than the value we look for
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // zero dollars needs no coin
        
        // for each amount, check all the coin possible
        for (int a = 1; a <= amount; a++) {
            for (int c: coins) {
                // if coin is less than or equal amount
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }
        
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}