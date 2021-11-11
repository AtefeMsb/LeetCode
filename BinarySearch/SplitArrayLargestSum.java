class Solution {
    public int splitArray(int[] nums, int m) {
        // find the sorted range
        int maxValue = 0;
        int sumValue = 0;
        for (int num : nums) {
            // maxValue would be the minimum of the largest sum,
            // because any split that contains it would be at least maxValue in size
            maxValue = Math.max(maxValue, num);
            sumValue = sumValue + num;
        }
        
        // binary search range [maxValue, sumValue]
        int left = maxValue;
        int right = sumValue;
        
        while (left < right) {
            
            int mid = left + (right - left) / 2;
            // condition: none of the subarrays can exceed this mid value
            int pieces = split(nums, mid);
            
            // created too many pieces
            if (pieces > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
        }
        
        return left; 
    }
    
    private int split(int[] nums, int mid) {
        int pieces = 1;
        int tempSum = 0;
        for (int num : nums) {
            if (tempSum + num > mid) {
                tempSum = num;
                pieces++;
            } else {
               tempSum += num; 
            }
        }
        
        return pieces;
    }
}