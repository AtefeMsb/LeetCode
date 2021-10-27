/**
 * recursion
 * time: O(2 ^ n)
 */
public class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        return recursion(nums, 0, 0, S);
    }
    
    // nums - index, sum do far - target
    public int recursion(int[] nums, int i, int sum, int S) {
        // if index reach the end of the nums array
        if (i == nums.length) {
            
            // if sum so far is equal target, we found a new way
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
            
        } else {
            int add = recursion(nums, i + 1, sum + nums[i], S);   
            int subtract = recursion(nums, i + 1, sum - nums[i], S);  
            return add + subtract;
        }
    }
}
// ------------------------------------------------------
/**
 * memoization
 * Time complexity: O(t⋅n). The memo array of size O(t⋅n) has been filled just once. Here, t refers to the sum of the nums array and n refers to the length of the snums array.
 */
public class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        return recursion(nums, 0, 0, S, new HashMap<String, Integer>());
    }
    
    // nums - index, sum do far - target
    public int recursion(int[] nums, int i, int sum, int S, Map<String, Integer> memo) {
        
        String key = i + "," + sum;
        // check the memo
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // if index reach the end of the nums array
        if (i == nums.length) {
            
            // if sum so far is equal target, we found a new way
            if (sum == S) {
                
                memo.put(key, 1);
                return 1;
                
            } else {
                
                memo.put(key, 0);
                return 0;
            }
            
        } else {
            int add = recursion(nums, i + 1, sum + nums[i], S, memo);   
            int subtract = recursion(nums, i + 1, sum - nums[i], S, memo);
            int result = add + subtract;
            memo.put(key, result);
            return result;
        }
    }
}
// ----------------------------------------------------
/**
 * Tabulation
 */