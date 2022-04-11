// O(n ^ 2)
class Solution {
    public long subArrayRanges(int[] nums) {
        
        int sum = 0;
        
        // strating point
        for (int i = 0; i < nums.length; i++) {
            
            int min = nums[i];
            int max = nums[i];
           
           // len of subarray
           for (int j = i; j < nums.length; j++) {
               min = Math.min(min, nums[j]);
               max = Math.max(max, nums[j]);
               sum += (max - min);
           }
       } 
        
        return sum; 
    }
}

////////////////////////////////////////////////////////
// O(n)