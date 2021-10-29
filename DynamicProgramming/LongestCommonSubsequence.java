/**
* memoization
* time complexity: O(M⋅N) - M and N are lengths of strings
* space complexity: O(M⋅N) 
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return memoization(text1, text2, 0, 0, new HashMap<String, Integer>());  
    }
    
    public int memoization(String text1, String text2, int i, int j, Map<String, Integer> memo) {
        
        // base case
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        
        // check the memo
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int count = 0;
        // found one similar character
        if (text1.charAt(i) == text2.charAt(j)) {
            count = 1 + memoization(text1, text2, i + 1, j + 1, memo);
            
        } else {
            count = Math.max(memoization(text1, text2, i + 1, j, memo),
                                 memoization(text1, text2, i, j + 1, memo));
            
        }
        
        memo.put(key, count);
        return count;
    }
}
// ==============================================
// src: https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestCommonSubsequence/BottomUp.java
/**
 * dynamic programming - tabulation
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] table = new int[text1.length() + 1][text2.length() + 1];
        
        // iterate each row
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                
                // base case - empty strings
                if (i == 0 || j == 0) {
                    
                    table[i][j] = 0;
                    
                // Characters match. Remove both and lengthen the best answer at the subproblem
                // without either final character. That is the answer to this subproblem.
                }else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    
                    table[i][j] = table[i - 1][j - 1] + 1;
                    
                // Character mismatch. No +1 happens, we can't lengthen the lcs. But we do need
                // to compete subproblems to find the answer to this one.
                } else {
                    
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                    
                }
            }
        }
        
        return table[text1.length()][text2.length()];
        
    }
}

// ----------------------------------------------------------------
/**
 * more readable dp by me
 */

 // fill the table from top to down
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        // first col is zero
        for (int i = 0; i < text1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        // first row is zero
        for (int j = 0; j < text2.length() + 1; j++) {
            dp[0][j] = 0;
        }
        
        // i and j starts from 1 because thge first row and col in table are zero
        // BUT in string we need to start from index 0, so we have to compare (i-1) and (j-1) indices
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
             
             // if found similar characters, add one to the diagnoal element
             if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
            // if no similar, maximum of element in last row and element in last col
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
              
            }
        }
     
        return dp[text1.length()][text2.length()];
        
    }
}