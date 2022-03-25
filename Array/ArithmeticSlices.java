class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int count = 0;
        
        // leave the last 2 elements, because the min size must be 3
        for (int i = 0; i < nums.length - 2; i++) {
            // the distance between the first 2 consecutive element
            int d = nums[i + 1] - nums[i];
            // find out how many more elements can be attach to this arithmetic slices
            for (int j = i + 2; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == d) {
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count;
    }
}