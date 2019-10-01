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
