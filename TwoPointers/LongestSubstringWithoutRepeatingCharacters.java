/**
 * sliding window
 * time: O(n)
 * space: O(n)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // visited set
        Set<Character> set = new HashSet<>();
        int result = 0;
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // if right char has been seen, we keep removing from left till right char gets removed from visited set
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(s.charAt(right));
            
            result = Math.max(result, right - left + 1);
            
        }
        
        return result;
    }
}