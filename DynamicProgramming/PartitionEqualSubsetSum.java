/** brute force - Time Limit Exceeded
 * time complexity: O(2 ^ n) exponential
 * space complexity: O(n)
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        
        return recursion(nums, 0, sum / 2);
    }
    
    private boolean recursion(int[] nums, int index, int sum) {
        
        // base case
        if (sum == 0) return true;
        if (sum < 0 || index == nums.length) return false;
        
        // don't pick the item at index or pick it, whichever gets the target sum to ZERO
        return recursion(nums, index + 1, sum) ||
               recursion(nums, index + 1, sum - nums[index]);
    }
}
// =================================================
/** dynamic programming with memoization
 * time complexity: O(m.n) - n be the number of array elements and m be the sum
 * space complexity: O(n)
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        
        // if there are a substring with half the amount, it means it is possible to 
        // divide the target sum, into 2 equal size substrings
        return recursion(nums, 0, sum / 2, new HashMap<String, Boolean>());
    }
    
    private boolean recursion(int[] nums, int index, int sum, Map<String, Boolean> memo) {
        
        // check the memo table
        if (memo.containsKey(index + "," + sum)) {
            return memo.get(index + "," + sum);
        }
        
        // base case
        if (sum == 0) return true;
        if (sum < 0 || index == nums.length) return false;
        
        
        // don't pick the item at index or pick it, whichever gets the target sum to ZERO
        boolean result =  recursion(nums, index + 1, sum, memo) ||
                          recursion(nums, index + 1, sum - nums[index], memo);
        
        memo.put(index + "," + sum, result);
        return result;
    }
}
