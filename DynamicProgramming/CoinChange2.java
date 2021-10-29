// source: https://www.youtube.com/watch?v=Mjy4hd2xgrs&t=632s
/**
 * tabulation
 */
class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] table = new int[coins.length + 1][amount + 1];
        table[0][0] = 1;    // there is one way to make amount 0 with no coin
        
        for (int row = 1; row <= coins.length; row++) {
            table[row][0] = 1;  // there is one way to make amount 0 with any amount of coins
            for (int col = 1; col <= amount; col++) {
                
                if (coins[row - 1] > col) {
                    // don't take it
                   table[row][col] = table[row - 1][col]; 
                } else {
                    // 2 options: not taking the cur + taking the cur
                    table[row][col] = table[row - 1][col] + table[row][col - coins[row - 1]];
                }
            }
        }
        
        return table[coins.length][amount];
    }
}

// -----------------------------------------------------
/**
 * memoization
 */
class Solution {
    
    public int change(int amount, int[] coins) {
        
        // edge case
        if (coins.length == 0) return 0;
        
        return memoization(amount, coins, 0, new HashMap<String, Integer>());
        
    }
    
    public int memoization(int amount, int[] coins, int index, Map<String, Integer> memo) {
        
        // base case
        // can not find a solution
         if (index >= coins.length || amount < 0) {
            return 0;
        }
        
        // a possible solution is found
        if (amount == 0) {
            return 1;
        }
        
        // check memo table
        String key = index + "-" + amount;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        
        // choices are 1. pick this coin OR  2. not pick this coin
        int temp = memoization(amount - coins[index], coins, index, memo) + memoization(amount, coins, index + 1, memo);
        memo.put(key, temp);

        return temp;
    }
}