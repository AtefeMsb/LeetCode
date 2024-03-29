/**
 * memoization
 */
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        // at each index, look for odd and even substring
        for (int i = 0; i < s.length(); i++) {
            
            count += helper(s, i, i);
            count += helper(s, i, i + 1);
     
        }
        
        return count;
        
    }
    
     public int helper(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        
        return count;
    }
}

// --------------------------------
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