class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        // key: prefix sum - value: index
        // If we run into a duplicate (which is possible because of negative numbers),
        // we should not update the index in the hash map because we want the longest subarray
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;    // thsi is prefix sum
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            int delta = sum - k;
            
            // If any subarray seen so far sums to k, then
            // update the length of the longest_subarray. 
            if (map.containsKey(delta)) {
            
                maxLength = Math.max(maxLength, (i - map.get(delta)));
            }
            
            // Only add the current prefix_sum index pair to the 
            // map if the prefix_sum is not already in the map.
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
       
        }
        
        return maxLength;
        
    }
}