package TopInterview;

public class LongestPalindromicSubstring {

    // class variables 
    int resultLength;
    int resulltStart;
    
    public String longestPalindrome(String s) {
      
        // boundry check
        if (s == null) return null;
        if ( s.length() < 2) return s;
        
        // check every character is the possible missle of the longest palindrome
        for (int middle = 0; middle < s.length() - 1; middle++) {
            // if substring length is odd
            expandRangeFromMiddle(s, middle, middle);
            // if substring length is even
            expandRangeFromMiddle(s, middle, middle + 1);
        }
        
        return s.substring(resulltStart, resulltStart + resultLength);
    }
    
    // this function finds the longest palindrome starts from middle of string
    private void expandRangeFromMiddle(String str, int begin, int end) {

        // move forward while the palindrome condition hold
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        
        if (end - begin - 1 > resultLength) {
            resultLength = end - begin - 1;
            resulltStart = begin + 1;
        }        
    }    
    
}