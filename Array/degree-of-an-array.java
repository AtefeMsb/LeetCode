/*
this solution uses 2 hashmap.
one to keep frequency and one to keep index of first seen location
In each iteration we update the degree to the maximum so far 
also, update minLength of subarray to minimum so far
*/
class Solution {
    public int findShortestSubArray(int[] nums) {
        
        // Key: number, Value: frequency of the element
        Map<Integer, Integer> freqMap = new HashMap<>();
        int degree = 0;
        
        // Key: number, Value: first index index has been seen
        Map<Integer, Integer> firstSeen = new HashMap<>();
        int minLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            
            if (freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            // first time seen    
            } else {
                freqMap.put(nums[i], 1);
                // add first time seen index to value
                firstSeen.put(nums[i], i);
            }
                
            // update the degree if found something bigger
            if (freqMap.get(nums[i]) > degree) {
                degree = freqMap.get(nums[i]);
                // update the minLength for the updated degree
                minLength = (i - firstSeen.get(nums[i])) + 1;
            // if the same degree, just make sure minLength is smallest
            } else if(freqMap.get(nums[i]) == degree) { 
                minLength = Math.min(minLength, (i - firstSeen.get(nums[i])) + 1);
            }     
        }   
        return minLength;
    }
}
