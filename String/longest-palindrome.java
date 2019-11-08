class Solution {
    public int longestPalindrome(String s) {
        
        // counting occurence of each character in s
        char[] charCounts = new char[128];
        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }
        
        int result = 0;
        for (int count : charCounts) {
            // if its odd 3/2 = 1 (integer division- removes the remainder) * 2 = 2
            result += count / 2 * 2;
            if (result % 2 == 0 && count % 2 == 1) {
                result += 1;
            }
        }
        
        return result;
    }
}
