class Solution {
    public int maximumProduct(int[] nums) {
        
        int l = nums.length;
        Arrays.sort(nums);
        
        return Math.max((nums[0] * nums[1] * nums[l - 1]) , (nums[l - 1] * nums[l - 2] * nums[l - 3]) );
    }
}
