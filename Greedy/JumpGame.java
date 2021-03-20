package Greedy;

/**
 * solution 1
 * Backtracking: explore all the way can jump from each index
 * Time complexity : O(2^n)
 * Space complexity : O(n)
 */
class Solution {
    public boolean canJump(int[] nums) {
        return backTracking(nums, 0);
    }
    
    private boolean backTracking(int[] nums, int pos) {
        
        // base case - if reached the last index
        if (pos == nums.length - 1) {
            return true;
        }
        
        // the furthest to jump
        int furtestPos = Math.min(pos + nums[pos], nums.length - 1);
        
        // try all possible jumps from each pos
        for (int i = pos + 1; i <= furtestPos; i++) {
            if (backTracking(nums, i)) {
                return true;
            }
        }
        
        return false;
    }
}
//---------------------------------------------------------------------------
/**
 * solution 2
 * dynamic programming - memoization
 * Time complexity : O(n ^ 2)
 * Space complexity : O(n)
 */

class Solution2 {
    public boolean canJump(int[] nums) {
        return backTracking(nums, 0, new HashMap<>());
    }
    
    private boolean backTracking(int[] nums, int pos, HashMap <Integer, Boolean> memo) {
        
        // search the memo first
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        
        // base case - if reached the last index
        if (pos == nums.length - 1) {
            return true;
        }
        
        // the furthest to jump
        int furtestPos = Math.min(pos + nums[pos], nums.length - 1);
        
        // try all possible jumps from each pos
        for (int i = pos + 1; i <= furtestPos; i++) {
            if (backTracking(nums, i, memo)) {
                memo.put(pos, true);
                return true;
            }
        }
        
        memo.put(pos, false);
        return false;
    }
}

//---------------------------------------------------------------------------
/**
 * solution 3
 * dynamic programming - tabulation
 * Time complexity : O(n ^ 2)
 * Space complexity : O(n)
 */

class Solution3 {
    public boolean canJump(int[] nums) {
        
        boolean[] table = new boolean[nums.length];
        for (int i = 0; i < table.length; i++) {
            table[i] = false;
        }
        
        // base case - last index is true
        table[nums.length - 1] = true;
        
        // backward
        for (int i = nums.length - 2; i >= 0; i--) {
            // most jump can be made from the i pos
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            // if reach one true from the current pos, break
            for (int j = i + 1; j <= furthestJump; j++) {
                if (table[j] == true) {
                    table[i] = true;
                    break;
                }
            }
        }
        
        return table[0];
    }
}

//---------------------------------------------------------------------------
/**
 * solution 4
 * greedy
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

class Solution4 {
    public boolean canJump(int[] nums) {
        // left most index that can reach the last index
        int lastGoodPos = nums.length - 1;
        
        // backward
        for (int i = nums.length - 1; i >= 0; i--) {
            // if the most left good value is reachable from index i
            if (i + nums[i] >= lastGoodPos) {
                lastGoodPos = i;
            }
        }
        
        return lastGoodPos == 0;
    }
}