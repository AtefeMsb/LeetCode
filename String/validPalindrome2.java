package String;

class Solution {
    // function check if is possible to make an string palindrome by removibg one of its characters
    public boolean validPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                
                // check 2 situtation: 1. remove left character 2. remove right character
                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
                
            }
        }
        
        return true;
    }
    
    // function check if a string is palindrome or not
    private boolean isPalindrome(String s, int left, int right) {
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}