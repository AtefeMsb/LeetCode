class Solution {
    public int countBinarySubstrings(String s) {
        
        // find count of numbers at each group of similar consecutive characters
        List<Integer> groups = new ArrayList<>();
        groups.add(1);
        
        for (int i = 1; i < s.length(); i++) {
            // found a new group of charactrers
            if (s.charAt(i) != s.charAt(i - 1)) {
                groups.add(1);
            } else {
                int lastIndex = groups.size() - 1;
                groups.set(lastIndex, groups.get(lastIndex) + 1);
            }
        }
       
        System.out.println(groups);
        
        // between each group the number of substrings would be equal the number of min len
        // 1100 -> has 2 substrings but 11110000 -> has 4 substrings
        int res = 0;
        for (int i = 1; i < groups.size(); i++) {
            res += Math.min(groups.get(i), groups.get(i - 1));
        }
        
        return res;
    }

}

//----------------------------------------------------------------------
// count the group count as we go
class Solution {
    public int countBinarySubstrings(String s) {
        
        int res = 0;
        int prevCount = 0;
        int currCount = 1;
        
        int i = 1;
        
        while (i < s.length()) {
            
            // if reached a new character, start counting for a new group
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(prevCount, currCount);
                prevCount = currCount;
                currCount = 1;
            } else {
                currCount++;
            }
            
            i++; 
        }
        
        res += Math.min(prevCount, currCount);;
   
        return res;
    }
}