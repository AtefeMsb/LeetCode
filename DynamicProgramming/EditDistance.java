/**
 * memoization
 */
class Solution {
    public int minDistance(String word1, String word2) {
        return memoization(word1, word2, 0, 0, new HashMap<String, Integer>()); 
    }
    
    public int memoization(String word1, String word2, int i, int j, Map<String, Integer> memo) {
        
        // base case
        if (j == word2.length()) {
            return word1.length() - i;
        }
            
        if (i == word1.length()) {
            return word2.length() - j;
        }
            
        
        // check the memo
        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // logic
        int count = 0;
        
        // if the current character is the same
        if (word1.charAt(i) == word2.charAt(j)) {
            
            count = memoization(word1, word2, i + 1, j + 1, memo);
            
        } else {
            
            int insert = memoization(word1, word2, i, j + 1, memo);
            int delete = memoization(word1, word2, i + 1, j, memo);
            int replace = memoization(word1, word2, i + 1, j + 1, memo);
            
            count = 1 + Math.min(insert, Math.min(delete, replace));
        }
        
        
        memo.put(key, count);
        return count;
       
    }
}

// -------------------------------------------------
/**
 * dp
 */
class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // first col
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        
        // first row
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    
                    dp[i][j] = dp[i - 1][j - 1];
                    
                } else {
                    
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                    
                }
            }
        }
        
        return dp[n][m];
        
    }
}