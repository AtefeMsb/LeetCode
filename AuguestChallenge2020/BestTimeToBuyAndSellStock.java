package AuguestChallenge2020;

// one pass
// keep the smallest value followed by the largest profit
class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            
            if (prices[i] < minPrice) {
                
                minPrice = prices[i];
                
            } else if (prices[i] - minPrice > maxProfit) {
                
                maxProfit = prices[i] - minPrice;
            
            }
        }
        
        return maxProfit;
    }
}