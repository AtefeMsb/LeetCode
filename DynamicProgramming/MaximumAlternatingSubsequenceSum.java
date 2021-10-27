class Solution {
    public long maxAlternatingSum(int[] nums) {
        // start from index 0, so isEven is true
        return memoization(nums, 0, true, new HashMap<String, Long>());
    }
    
    public long memoization(int[] nums, int index, boolean isEven, Map<String, Long> memo) {
        
        // base case - if index reach teh end of the array
        if (index == nums.length) {
            return 0;
        }
        
        // check the memo table
        String key = index + "," + isEven;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // logic is to sum the even number and subtract the odd ones
        long total = 0;
        total = (isEven == true) ? +1 * nums[index] : -1 * nums[index];
        
        // pick this index and add it to the result and flip the sign
        long pick = total + memoization(nums, index + 1, !isEven , memo);
        // not pick this index and leave the sign as it is
        long notPick = memoization(nums, index + 1, isEven, memo);
        
        long result = Math.max(pick, notPick);          
        memo.put(key, result);
        
        return result;
        
    }
}