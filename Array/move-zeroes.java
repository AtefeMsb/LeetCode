class Solution {
    public void moveZeroes(int[] nums) {
        
        // points to the end of non-zero string
        int pointer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            
            if (nums[pointer] == 0) {
                nums[pointer] = nums[i];
                nums[i] = 0;
                pointer++;
            } else {
                // move the pointer to an index with zero
                while (nums[pointer] == 0) {
                    pointer++;
                }
                nums[pointer] = nums[i];
                pointer++;
            }
        }
    }
}
