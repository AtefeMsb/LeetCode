class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        int maxLen = 0;
        // key: prefix sum -- val: the first occurence INDEX
        Map<Integer, Integer> map = new HashMap<>();
        // prefixSum zero happened at index -1
        map.put(0, -1);
        int prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int diff = prefixSum - k;
            
            if (map.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - map.get(diff)); 
            }
            
            // only add the prefixSum for the first time
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
    
        return maxLen;
    }
}