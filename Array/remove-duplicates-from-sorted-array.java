/*
class Solution {
    public int removeDuplicates(int[] nums) {
        
        // special cases
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        
        int length = 1;
        int currentIndex = 0;
        
        // check each new element with the currentIndex for similarity
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
*/

/*
Algorithm

Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while j is the fast-runner. As long as nums[i]=nums[j], we increment j to skip the duplicate.

When we encounter nums[j] != nums[i], the duplicate run has ended so we must copy its value to nums[i+1]. i is then incremented and we repeat the same process again until j reaches the end of array.
*/
class Solution {
    
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0) return 0;
        
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}