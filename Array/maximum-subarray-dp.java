/*
Dynamic Programming Solution
for each elemnt checks to see if sum of numbers till then + nums[i] is bigger or if
start a new subarray from then
Time Complexity: O(n)
Space Complexity: O(1) - only 2 extra variables are used
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

//------------------------------------------------------
// in this approach the space complexity is O(n) but it is more clear to understand
// dynamic programing with tabulation
class Solution2 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        
        int[] table = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            table[i] = 0;
        }
        
        table[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            table[i] = Math.max(nums[i], nums[i] + table[i - 1]);
            if (table[i] > max) {
                max = table[i];
            }
        }
        
        return max;
        
    }
}