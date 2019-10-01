class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        Map <Integer,Integer> freqMap =  new HashMap <Integer,Integer>(); 
        
        for (int i = 0; i < nums.length; i++) {
            // checks if the diffrence amount from this number to target is on map
            if (freqMap.containsKey(target - nums[i])) {
                result[0] = freqMap.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                // puts new item in the map 
                freqMap.put(nums[i], i);
            }
        }
    
        return result;
        
    }
}
