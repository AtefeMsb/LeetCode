/**
 * using binary operator : XOR (^)
 * time: O(n)
 * space: O(1)
 */

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



 // ---------------------------------------------
// set
class Solution {
    public int missingNumber(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int i = 0; i <= nums.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        
        return -1;
    }
}

// --------------------------------------------
// Gauss' Formula 
class Solution {
    public int missingNumber(int[] nums) {
        // sum of the first n natural numbers: n * (n + 1) / 2
        int expectedSum = nums.length * (nums.length + 1) / 2;
        
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
}
// ---------------------------------------------
// keeping sum of indices and sum of elements
class Solution {
    public int missingNumber(int[] nums) {
        
        int expectedSum = 0;    // sum of indices
        int actualSum = 0;      // sum of elements
        
        for (int i = 0; i < nums.length; i++) {
            expectedSum += i;
            actualSum += nums[i];
        }
        
        expectedSum += nums.length;
        
        return expectedSum - actualSum;
    }
}