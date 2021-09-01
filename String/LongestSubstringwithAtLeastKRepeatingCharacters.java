public class Solution {
    public int longestSubstring(String s, int k) {
        
        if (s == null || s.length() == 0) return 0;
        if (k == 1) return s.length();
        
        char[] chars = new char[26];
        
        // record the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < k && chars[i] > 0) {
              flag = false;  
            }      
        }
        
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        
        int result = 0;
        int start = 0;
        int cur = 0;
        
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        
        return result;
        
    }
}