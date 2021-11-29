class Solution {
    public String minWindow(String s, String t) {
  
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
  
        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }
        
        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();
  
        // ans list of the form (window length, left, right)
        int[] result = new int[]{-1, +1};
        int resultLen = Integer.MAX_VALUE;
  
        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();
        
        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;
  
        // Left and Right pointer
        int l = 0;
        int r = 0;g
        
      
  
        for (r = 0; r < s.length(); r++) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
  
            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
  
            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (r - l + 1 < resultLen) {
                    resultLen = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }
  
                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
  
                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }
    
        }
  
        return resultLen == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
  }