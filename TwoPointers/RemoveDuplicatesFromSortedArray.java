/**
 * TWO Pointer
 * time: O(n)
 * space: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        
        // pointer 1: (endOfListPtr) indicates the end of non-suplicate array
        int endOfListPtr = 0;
        // pointer 2: (i) travese the array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[endOfListPtr]) {
                endOfListPtr++;
                nums[endOfListPtr] = nums[i];
            }
        }
        
        // return the size of non-duplicated array
        return endOfListPtr + 1;  
    }
}