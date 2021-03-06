/**
* memoization
* time complexity: O(M⋅N) - M and N are lengths of strings
* space complexity: O(M⋅N) 
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return recursion(text1, text2, 0, 0, new HashMap<String, Integer>()); 
    }
        
        private int recursion(String text1, String text2, int i, int j, Map<String, Integer> memo) {
            
            // base case
            if (i >= text1.length() || j >= text2.length()) {
                return 0;
            }
            
            // check the memo
            if (memo.containsKey(i + "," + j)) {
                return memo.get(i + "," + j);
            }
            
            // if we found a match
            if (text1.charAt(i) == text2.charAt(j)) {
                int count = 1 + recursion(text1, text2, i + 1, j + 1, memo);
                memo.put(i + "," + j, count);
                return count;
            // if we didn't find a match
            } else {
                int count = Math.max(recursion(text1, text2, i + 1, j, memo),
                                     recursion(text1, text2, i, j + 1, memo));
                memo.put(i + "," + j, count);
                return count;
            }
            
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