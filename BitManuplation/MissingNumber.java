// num ^ 0 = num
// num ^ num = 0
class Solution {
    public int missingNumber(int[] nums) {
        
        int missing = 0;
        
        // xor all the indices, add the last index as well
        for (int i = 0; i <= nums.length; i++) {
            missing = missing ^ i;
        }
        // xor all the elements
        for (int num : nums) {
            missing = missing ^ num;
        }
        
        // what left is the missing number
        return missing;
    }
}