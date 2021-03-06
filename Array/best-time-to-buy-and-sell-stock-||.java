class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length == 0) { return 0;}
        int profit = 0;
        
        // compare each price with the next one to find if there is oppurtunity for profit
        for (int i = 0; i < prices.length - 1; i++) {
            // makes profit - buy on day ith and sell the next day
            if ((prices[i + 1]  - prices[i]) > 0) {
                profit += (prices[i + 1]  - prices[i]);
            }
        }
        
        return profit;
   
    }
}

/**
 * Simple One Pass
 */
class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}