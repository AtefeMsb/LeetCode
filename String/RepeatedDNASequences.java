/**
 * Linear-time Slice Using Substring + HashSet
 * time and space: O((N−L)L)
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < s.length() - 10 + 1; i++) {
            // create the substring with length of 10 from i
            String sub = s.substring(i, i + 10);
            
            // if it happened more than once
            if (seen.contains(sub)) {
                result.add(sub);
            }
            
            // add the substring to the seen set anyway
            seen.add(sub);
        }
        
        return new ArrayList<String>(result);
    }
}

// ----------------------------------------------------------------
/**
 * Rabin-Karp : Constant-time Slice Using Rolling Hash
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      int L = 10;
      int n = s.length();
      if (n <= L) {
          return new ArrayList();
      }
  
      // rolling hash parameters: base a
      int a = 4;
      int aL = (int)Math.pow(a, L);
  
      // convert string to array of integers
      Map<Character, Integer> toInt = new HashMap(); 
      toInt.put('A', 0);
      toInt.put('C', 1);
      toInt.put('G', 2);
      toInt.put('T', 3);
        
      // put the int representation of each character in the array
      int[] nums = new int[n];
      for(int i = 0; i < n; ++i) {
          nums[i] = toInt.get(s.charAt(i));
      }
        
      System.out.print(Arrays.toString(nums));
  
      int h = 0;
      Set<Integer> seen = new HashSet();
      Set<String> output = new HashSet();
        
      // iterate over all sequences of length L
      for (int start = 0; start < n - L + 1; ++start) {
        // compute hash of the current sequence in O(1) time
        if (start != 0) {
          h = h * a - nums[start - 1] * aL + nums[start + L - 1];
        }
        // compute hash of the first sequence in O(L) time
        else {
          for(int i = 0; i < L; ++i) {
              h = h * a + nums[i];
          } 
        }
          
        // update output and hashset of seen sequences
        if (seen.contains(h)) output.add(s.substring(start, start + L));
        seen.add(h);
      }
      return new ArrayList<String>(output);
    }
  }