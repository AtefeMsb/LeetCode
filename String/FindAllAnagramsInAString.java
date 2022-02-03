// using hashmap
// time complexity O(26n)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> output = new ArrayList<>();
        
        if (p.length() > s.length()) return output;
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        
        // sliding window O(n)
        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            
            // if more than p size, remove left character
            if (i >= p.length()) {
                int left = i - p.length();
                ch = s.charAt(left);
                if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, sMap.get(ch) - 1);
                }
            }
            
            // compare the two hashmap O(26)
            if (sMap.equals(pMap)) {
                output.add(i - p.length() + 1);
            }  
        }
        
        return output;
        
    }
}

// ---------------------------------------------------------
// uysing characters array
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      int ns = s.length();
      int np = p.length();
        
      List<Integer> output = new ArrayList();
      if (ns < np) return output;
  
      int [] pCount = new int[26];
      int [] sCount = new int[26];
        
      // build reference array using string p
      for (char ch : p.toCharArray()) {
        pCount[(ch - 'a')]++;
      }
        
        
      // sliding window on the string s
      for (int i = 0; i < ns; i++) {
        // add one more letter 
        // on the right side of the window
        sCount[(s.charAt(i) - 'a')]++;
          
        // remove one letter 
        // from the left side of the window
        if (i >= np) {
          sCount[(s.charAt(i - np) - 'a')]--;
        }
          
        // compare array in the sliding window
        // with the reference array
        if (Arrays.equals(pCount, sCount)) {
          output.add(i - np + 1);
        }
      }
        
      return output;
        
    }
  }
