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