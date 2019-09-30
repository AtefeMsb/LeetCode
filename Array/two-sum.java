class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        Map <Integer,Integer> freqMap =  new HashMap <Integer,Integer>(); 
        
        for (int i = 0; i < nums.length; i++) {
           
            if (freqMap.containsKey(nums[i])) {
                result[0] = freqMap.get(nums[i]);
                result[1] = i;
            } else {
                int diff = target - nums[i];
                freqMap.put(diff, i);
            }
        }
    
        return result;
        
    }
}
