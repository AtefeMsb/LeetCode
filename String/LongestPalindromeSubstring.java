package String;

/**
 * dynamic programming - tabulation
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 */

public class Solution {
    public static String longestPalindrome(String s) {
        
        int n = s.length();
        int palindromeStartsAt = 0; // start index of palindrome
        int maxLen = 0;

        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
        boolean[][] dp = new boolean[n][n];
        
        // i is start, j is the end of sunstring
        // so j must be always more than i
        for(int i = n - 1; i >= 0; i--) { // keep increasing the possible palindrome string
            for(int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)
                
                //check if substring between (i,j) is palindrome
                dp[i][j] = (s.charAt(i) == s.charAt(j)) // boundies must match: chars at i and j should match
                           && 
                           ( j-i < 3  // if window is less than or equal to 3, just end chars should match (diagnoal line and one above)
                             || dp[i+1][j-1]  ); // if window is > 3, substring (i+1, j-1) should be palindrome too
                
                //update max palindrome string
                if(dp[i][j] && (j-i+1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
    }
}
//------------------------------------------
/**
 * dynamic programming - tabulation
 * time complexity: O(n^2)
 * space complexity: O(1)
 */
class Solution {
    // keep start and length of palindrome
    int start = 0;
    int length = 0;
    
    public String longestPalindrome(String s) {
        
        for (int mid = 0; mid < s.length(); mid++) {
            
            // odd palindrome
           expandRange(s, mid, mid);
            // even palindrome
           expandRange(s, mid, mid + 1);
        }
        
        return s.substring(start, start + length);
        
    }
    
    private void expandRange(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
        
        // (right - left - 1) is because at the last round in the while loop left was left-- and right was right++
        // in general finding the length of substring using index of Start and End is with this formula: (End - Start + 1)
        // but here because of the changes in left and right: (right - 1 - (left + 1) + 1) = (right - left - 2 + 1)
        if (length < right - left - 1) {
            start = left + 1;
            length = right - left - 1;
        }
     
    }
}