/**
 * memoization
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
 * tabulation
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // to make faster, sort the coins
        Arrays.sort(coins);
        
        int[] table = new int[amount + 1];
        Arrays.fill(table, amount + 1);
        
        table[0] = 0;
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    table[i] = Math.min(table[i], 1 + table[i - coins[j]]);
                } else {
                    continue;
                }
            }
        }
        
        return table[amount] > amount ? -1 : table[amount];
    }
}