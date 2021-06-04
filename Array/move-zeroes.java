class Solution {
    public void moveZeroes(int[] nums) {
        
        // non-zero pointer
        int ptr = 0;
        
        // 1. if the element is non-zero, copy to the cell in non-zero pointer
        for (int num : nums) {
            if (num != 0) {
                nums[ptr] = num;
                ptr++;
            }
        }
        
        // 2. fill the rest of the array with zero
        for (int i = ptr; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
