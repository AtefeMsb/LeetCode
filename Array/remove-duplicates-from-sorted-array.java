class Solution {
    public int removeDuplicates(int[] nums) {
        
        int length = 1;
        int currentIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[currentIndex]) {
                continue;
            }
            
            nums[currentIndex + 1] = nums[i];
            currentIndex++;
            length++;
        }
    
        return length;
        
    }
}
