package TopInterview;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepeating {
        // Sliding Window
        public int lengthOfLongestSubstring(String s) {
        
            int max = 0;
            int left_ptr = 0;
            int right_ptr = 0;
            
            Set<Character> set = new HashSet<Character>();
          
            // right pointer expanding the window
            while (right_ptr < s.length()) {
                
                // if facing new characters
                if(!set.contains(s.charAt(right_ptr))) {
                    set.add(s.charAt(right_ptr));
                    right_ptr++;
                    max = Math.max(max, set.size());
                    
                // if facing repeated character
                } else {
                    set.remove(s.charAt(left_ptr));
                    left_ptr++;
                }
            }
            
            return max;
        }
}