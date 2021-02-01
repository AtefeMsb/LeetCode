package TwoPointers;

class Solution {
    public void moveZeroes(int[] nums) {
        
        // a pointer to point the location when non-zero should be inserted
        int index = 0;
        
        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }
        
        // fill the rest of the array with zeros
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}