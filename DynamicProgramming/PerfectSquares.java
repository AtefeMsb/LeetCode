/**
* Time complexity: O(n⋅ square-root(n))
* In main step, we have a nested loop, where the outer loop is of nn iterations and in the 
* inner loop it takes at maximum square-root(n) iterations.
* Space Complexity: O(n)
*/

class Solution {
    public int numSquares(int n) {
        
        int dp[] = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        // fill the dp array
        for (int target = 1; target < n + 1; target++) {
            // try all the possible squares
            for (int s = 1; s < n + 1; s++) {
                int square = s * s;
                // if square is more than target
                if (target - square < 0) {
                    break;
                }
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }
        
        return dp[n];
    }
}

// ---------------------------------------------
// dynamic programming using memoization
class Solution {
    public int numSquares(int n) {
        return memoization(n, new HashMap<>());
    }
    
    private int memoization(int n, HashMap<Integer, Integer> memo) {
        
        // check in memo table
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // base case
        if (n <= 3) return n;
        
        int ans = Integer.MAX_VALUE;
        
        // check for all the possible squares
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + memoization(n - (i * i), memo));
        }
        
        // update the memo table
        memo.put(n, ans);
        return ans;
        
    }
}