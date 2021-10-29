/**
 * memoization
 */
class Solution {
    public int numDistinct(String s, String t) {
        return memoization(s, t, 0, 0, new HashMap<String, Integer>());
    }
    
    public int memoization(String s, String t, int i, int j, Map<String, Integer> memo) {
        
        // base case
        // 1. if j reach the end, we found a matching subsequenece 
         if (j == t.length()) {
            return 1;
        }
        
        // 2. if i reach the end but j has not, no subsequence was found
        if (i == s.length() && j < t.length()) {
            return 0;
        }
        
        // check the memo table
        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // logic
        int count = 0;
        // if characters match, two things happens:
        // 1- we move on on both string AND
        // 2- j stayes and i moves for duplicate character to be counted as another possible subsequenece
        if (s.charAt(i) == t.charAt(j)) {
            count = memoization(s, t, i + 1, j + 1, memo) + memoization(s, t, i + 1, j, memo);
        } else {
            count = memoization(s, t, i + 1, j, memo);
        }
        
        memo.put(key, count);
        return count;
        
        
    }
}
// -----------------------------------------------------------
class Solution {
    public int numDistinct(String s, String t) {
        // array creation
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // filling the first row: with 1s
        for(int j =0 ; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for(int i = 1; i < t.length() + 1; i++) {
            for(int j = 1; j < s.length() + 1; j++) {

                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}