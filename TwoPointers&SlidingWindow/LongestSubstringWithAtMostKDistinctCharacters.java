class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if (s.length() == 0 || k == 0) return 0;
        
        int left = 0;
        int right = 0;
        int result = 0;
        // key: character       value: frequency of characters
        Map<Character, Integer> map = new HashMap<>();
        
        // forward the right pointer
        while (right < s.length()) {
            
            // expand the right pointer
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);
            
            // narrow down if reached the k distict character
            while (map.size() > k) {
                
                // removing one character from left at each iteration to reach the k most distict character again
                char l = s.charAt(left);
                if (map.get(l) == 1) {
                    map.remove(l);
                } else {
                    map.put(l, map.get(l) - 1);
                }
                
                left++;
            }
            
            result = Math.max(result, (right - left + 1));
            right++;
        }
        
        return result;
    }
}