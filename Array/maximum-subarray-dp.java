/*
Dynamic Programming Solution
for each elemnt checks to see if sum of numbers till then + nums[i] is bigger or if
start a new subarray from then
*/
class Solution {
    public int maxSubArray(int[] nums) {
        
        // biggest sum if the subarray ends at this index
        int maxEndingHere =  nums[0];
        // biggest of all maxEndingHere's
        int maxSofar = nums[0];
        
        
        for (int i = 1; i < nums.length ; i++) {
            
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSofar =  Math.max(maxSofar, maxEndingHere);
            
        }
        
        return maxSofar;
    }
}
