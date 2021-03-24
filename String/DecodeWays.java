package String;

/**
* Solution 1: dynamic programming - recursive memoization
* Time complexity: O(n)
* Space Complexity: O(n)
*/
class Solution {
    public int numDecodings(String s) {
        return memoization(0, s, new HashMap<>());
    }
    
    private int memoization(int index, String s, HashMap<Integer, Integer> memo) {
        
        // Have we already seen this substring?
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        // If you reach the end of the string
        // Return 1 for success.
        if (index == s.length()) {
            return 1;
        }
        
        // If the string starts with a zero, it can't be decoded
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        // If at last value of array, there is one way
         if (index == s.length() - 1) {
            return 1;
        }
        
        // next substring from index + 1 (1 digit)
        int ans = memoization(index + 1, s, memo);
        // if potentionally can use 2 number for decoding (2 digits)
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += memoization(index + 2, s, memo);
        }
        
         // Save for memoization
        memo.put(index, ans);
     
        return ans;
    }
    
}
// --------------------------------------
/**
* Solution 2: dynamic programming - tabulation
* Time complexity: O(n)
* Space Complexity: O(n)
*/
class Solution2 {

    public int numDecodings(String s) {
        
        // if string start with zero, there is no way to decode it
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        // DP array store max ways to decode the string up to the index
        int[] dp = new int[s.length() + 1];
        // empty string 
        dp[0] = 1;
        
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= s.length(); i++) {
            // Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
               dp[i] = dp[i - 1];  
            }
            
            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}