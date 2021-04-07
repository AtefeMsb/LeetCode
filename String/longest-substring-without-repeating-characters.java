/**
 * sliding window
 * time complexity: O(n)
 * space complexity: O(min(m,n)). We need O(k) space for the sliding window, where k is the size of the Set.
 * The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;   // contract
        int right = 0;  // extend
        
        int max = 0;
        Set<Character> set = new HashSet<>();
        
        while (right < s.length()) {
            
            // if hit new character, expand from the right side
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, set.size());
            // if hit repeted character, shrink from the left side
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            
        }
        
        return max;  
    }
}
// ---------------------------------------
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // character - its index
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        
        while (right < s.length()) {
            
            char r = s.charAt(right);
            Integer rIndex = map.get(r);
            
            // if the r character happend before in between [left, right]
            // shrink from the left
            if (rIndex != null && rIndex >= left && rIndex < right) {
                left = rIndex + 1;
            }
            
            res = Math.max(res, right - left + 1);

            map.put(r, right);
            right++;
        }

        return res;
    }
}
// ------------------------------------------
/**
 * FASTEST SOLUTION
 * time complexity: O(n)
 * space complexity: O(m) - m is the size of the charset/alphabet
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128];
        int left = 0;
        int right = 0;
        int max = 0;
        
        // while right pointer has not recah the end of string
        while (right < s.length()) {
            
            // what is the character at index right
            char r = s.charAt(right);
            // what is the index if the r character has been seen before
            Integer index = chars[r];
            
            // if r character has been seen before, and it is in this range [left, right)
            // move the left to one step after index
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }
            
            // update the max with the current range
            max = Math.max(max, right - left + 1);
            
            // add character at right index to the array
            chars[r] = right;
            // expand the range
            right++;
        }
        
        return max;
    }
}