// BRUTH FORCE
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max  = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                }else {
                    set.add(c);
                    count++;
                    if (count > max) {max = count;}
                }
            }
        }
        
        return max;
    }
}
*/

// SLIDING WINDOW - TWO POINTERS
class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        int l = 0;
        int r = 0;
        int max = 0;
        
        Set<Character> set = new HashSet();
        
        while (r < s.length()) {
            char c = s.charAt(r);
            // expanding the window from right
            if (!set.contains(c)) {
                r++;
                set.add(c);
                max = Math.max(max, set.size());
                // shrinking window from left
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        
        return max;
       
    }
}
