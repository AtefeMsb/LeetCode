class Solution {
    public int arrayPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int sum = 0;
        
        // since array is sorted, and the first of 2 is always the minimum
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }
        
        return sum;
    }
}
