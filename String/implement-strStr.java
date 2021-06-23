/**
 * check needle starting from each character in haystack
 * time: O(n ^ 2)
 * space: O(1)
 */
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

///////////////////////////////////////////////////////
// Approach 1: Substring: Linear Time Slice
// Time complexity: O((N−L)L) where N is a length of haystack and L is a length of needle. We compute a substring of length L in a loop, which is executed (N - L) times.
// Space complexity: O(1).
class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            
            String sub = haystack.substring(i, i + needle.length());
            if (sub.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}

//////////////////////////////////////////////////////
// Approach 2: Two Pointers: Linear Time Slice
class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        if (nLen == 0) return 0;
        
        int hPtr = 0;   // haystack pointer
        int nPtr = 0;   // needle pointer
        
        // look for the first character of needle in haystack
        // when found start pattern matching with needle
        // if not found, back to the last place of haystack pointer + 1
        while (hPtr < hLen - nLen + 1) {
            
            // find the first needle characer
            while (hPtr < hLen - nLen + 1 && haystack.charAt(hPtr) != needle.charAt(0)) {
                hPtr++;
            }
            
            // pattern match to needle
            // make sure to count the steps taken to be able to backtrack later
            // also make sure to reset needle ptr to zero
            int steps = 0;
            nPtr = 0;
            while (nPtr < nLen && hPtr < hLen && haystack.charAt(hPtr) == needle.charAt(nPtr)) {
                hPtr++;
                nPtr++;
                steps++;
            }
            
            // if the whole needle was found
            if (steps == nLen) return hPtr - nLen;
            
            // otherwise, get back to the previous pn + 1
            hPtr = hPtr - steps + 1;
            
        }
        
        return -1;
        
    }
}
///////////////////////////////////////////////////////////
// rabin-karp algorithm