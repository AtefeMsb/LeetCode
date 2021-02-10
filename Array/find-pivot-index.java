class Solution {
    public int pivotIndex(int[] nums) {
        
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
                
         for (int i = 0; i < prefix.length; i++) {
             int left = prefix[i] - nums[i];
             int right = prefix[nums.length - 1] - prefix[i];
             if (left == right) {
                 return i;
             }
         }
        
        return -1;
    }
}