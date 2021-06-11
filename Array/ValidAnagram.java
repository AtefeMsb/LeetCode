/**
 * sorting
 * time complexity: O(logn)
 * space complexity: O(n) - toCharArray() makes a copy of the string so it costs O(n) extra space
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < s.length(); i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }
        
        return true;
    }
}

/**
 * hash table
 * time complexity: O(n)
 * space complexity: O(1)
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * Use a hash table instead of a fixed size counter. Imagine allocating a large size array to fit the entire range of unicode characters,
 * which could go up to more than 1 million. A hash table is a more generic solution and could adapt to any range of characters.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // add the count in s
            count[s.charAt(i) - 'a']++;
            // subtract the count in t
            count[t.charAt(i) - 'a']--;
        }
        
        // if s and t are anagram, all the elements of count should be ZERO
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}