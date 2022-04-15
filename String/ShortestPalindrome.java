// intuition: find the longest palindrom starting from first character
class Solution {
    public String shortestPalindrome(String s) {
        int i = 0;
        int end = s.length() - 1;
        int j = end;
        
        char chars[] = s.toCharArray();
        
        while(i < j) {
             if (chars[i] == chars[j]) {
                 i++;
                 j--;
             } else { 
                 // try a diffrent end
                 i = 0;
                 end--;
                 j = end;
             }
        }
        
        // reverse the non palindrome portion from the end and add its reverse to the begining
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
        
    }
}