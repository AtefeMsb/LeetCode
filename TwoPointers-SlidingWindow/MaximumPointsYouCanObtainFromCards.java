class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int left = 0;
        int right = cardPoints.length - k;
        int total = 0;
        
        // everything outside the sliding window is going to be the sum
        for (int i = right; i < cardPoints.length; i++) {
            total += cardPoints[i];
        }
        
        int result = total;
        
        while (right < cardPoints.length) {
            // because we releaze left i to outside of window
            // and include right into the sliding window
            total = total + cardPoints[left] - cardPoints[right];
            result = Math.max(result, total);
            left++;
            right++;
        }
        
        return result;
    }
}