class Solution {
    public int minEatingSpeed(int[] piles, int h) {
                
        int max = 1;
        for (int num : piles) {
            max = Math.max(max, num);
        }
        
        int result = max;
        
        // [1, max]
        int left = 1;
        int right = max;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            
            for (int p : piles) {
                hours += p / mid;
                // add the ceiling to the hourse
                if (p % mid != 0) {
                    hours++;
                }
            }
            
            // if hours is in range
            // lets try to make the rate smaller
            if (hours <= h) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
}