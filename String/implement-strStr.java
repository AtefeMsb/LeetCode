class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle.length() == 0) {return 0;}
        
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        
        // if haystack is shorter than needle, return -1
        if (haystackLen < needleLen) {
            return -1;
        }
        
        // for each character in haystack find needle
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int j;
            // if needle one char didnt match, start from the next char in haystack
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
            // if all the char in needle same as haystack return the index
            if (j == needleLen) {
                return i;
            }
            
        }
        return -1;
    }
}
