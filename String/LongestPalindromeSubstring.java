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
    
    public String longestPalindrome(String s) {
      
        // boundry check
        if (s == null) return null;
        if ( s.length() < 2) return s;
        
        int start = 0;
        int end = 0;
        
        // check every character is the possible missle of the longest palindrome
        for (int middle = 0; middle < s.length() - 1; middle++) {
            // if substring length is odd
            int len1 = expandRangeFromMiddle(s, middle, middle);
            // if substring length is even
            int len2 = expandRangeFromMiddle(s, middle, middle + 1);
            
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = middle - ((len - 1) / 2);
                end = middle + (len / 2);     
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // this function finds the longest palindrome starts from middle of string
    private int expandRangeFromMiddle(String str, int begin, int end) {

        // move forward while the palindrome condition hold
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        
        return end - begin - 1; 
              
    }
}