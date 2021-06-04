package DynamicProgramming;
/**
 * solution 1 : dynamic programming - tabulation
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
//---------------------------------------
/**
 * solution 2 : dynamic programming - memoization
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution2 {
    public int climbStairs(int n) {
        return memoization(0, n, new HashMap<>());
    }
    
    private int memoization(int i, int n, HashMap<Integer, Integer> memo) {
        
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        if (i > n) {
             return 0;
         }
        
        if (i == n) {
            return 1;
        }
        
        memo.put(i, memoization(i + 1, n, memo) + memoization(i + 2, n, memo));
                
        return memo.get(i);
    }
}
