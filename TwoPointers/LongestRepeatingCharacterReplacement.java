/** 
 * Sliding Window 
 * time: O(26.n)
 * space: O(1) because map is maximum 26
 */

class Solution {
    public int characterReplacement(String s, int k) {
        
        // keep the frequency of each character in the current sequence (max length: 26)
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int right = 0;
        
        while (right < s.length()) {
            // update the frequency map
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            // when the sequence is NOT VALID
            // window_length - most_frequent_character > k
            // there is no way to replace k  cahracter and make this sequence valid
            while ((right - left + 1) - Collections.max(map.values()) > k) {
                // forward the left character and decrese its frequency by 1
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left += 1;  
            }
            
            // after the sequence is valid, update the result
            result = Math.max(result, (right - left + 1));
            right += 1;
        }
        
        return result;   
        
    }
}