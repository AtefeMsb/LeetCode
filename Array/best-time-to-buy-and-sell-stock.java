/*
update min (price of buy) in each iteration if current value is less than previous min value
ELSE calculate profit for this day and compare it with current profit and update the profit
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        // profit made so far
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            // update the buy price
            if (prices[i] < min) {
                min = prices[i];
                // calculate the profit at this day
            } else { 
                profit = Math.max (profit , prices[i] - min); 
            }
        }
        
        return profit;
    }
}
