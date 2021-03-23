class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0 || strs == null) {
            return sb.toString();
        }
        
        // check each character of the first string to the all other strings
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                
                // check
                // 1: index is not out of bound for any of the strings
                // 2: character is the same for every string 
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }    
            }
            
            // if index was equal in all strings, add to the list of commons
            sb.append(strs[0].charAt(i));
        }
        
 
        return sb.toString();
    }
}