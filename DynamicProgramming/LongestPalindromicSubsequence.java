class Solution {
    public int longestPalindromeSubseq(String s) {
        return memoization(s, 0, s.length() - 1, new HashMap<String, Integer>());
    }
    
    public int memoization(String s, int left, int right, Map<String, Integer> memo) {
        
        // base case
        // if left pass the right, means the search is over, return 0
        if (left > right) {
            return 0;
        }
        
        // if on the same character, return length of 1
        if (left == right) {
            return 1;
        }
        
        String key = left + "-" + right;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int count = 0;
        // if equal, move both pointers and add 2 to the final result (becauuse 2 new character added to subsequenece)
        if (s.charAt(left) == s.charAt(right)) {
            count = memoization(s, left + 1, right - 1, memo) + 2;
        } else {
            count = Math.max(memoization(s, left + 1, right, memo), memoization(s, left, right - 1, memo));
        }
        
        memo.put(key, count);
        return count;
        
    }
}

// ----------------------------------------------
/**
 * tabulation
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

// ----------------
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            
            dp[i][i] = 1;
            
            for (int j = i - 1; j >= 0; j--) {
                
                if (s.charAt(i) == s.charAt(j)) {
                    
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                    
                } else {
                    
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                    
                }
            }
        }
        
        return dp[s.length()-1][0];
    }
}

