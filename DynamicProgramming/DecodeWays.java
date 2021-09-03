/**
 * memoization
 * time: O(n) does one recursive for each index
 * space: O(n)
 */
class Solution {
    public int numDecodings(String s) {
        return memoization(0, s, new HashMap<Integer, Integer>());
    }
    
    public int memoization(int index, String s, Map<Integer, Integer> memo) {
        
        // check the memo cache
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        // if reach the end of the string, return 1 for success
        if (index == s.length()) {
            return 1;
        }
        
        // if the string starts with zero, it can't be decoded
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        // if last value of the array, there is one way to decode it
        if (index == s.length() - 1) {
            return 1;
        }
        
        int result = memoization(index + 1, s, memo);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            result += memoization(index + 2, s, memo);
        }
        
        // save to memo cache
        memo.put(index, result);
        return result;
    }
}
// ==========================================
/**
 * dynamic programming
 */

class Solution {
    public int numDecodings(String s) {
        
        if (s.charAt(0) == '0') return 0;   // if first character is zero
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  // empty string
        dp[1] = 1;  // first character that we know is non-zero
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        } 
        
        return dp[n];
    }
}
