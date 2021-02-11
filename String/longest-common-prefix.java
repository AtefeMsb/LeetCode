class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        
        int index = 0;
        // compare characeter at index of first string with all other strings character at the same index
        for (char c : strs[0].toCharArray()) {
            // strings after first string
            for (int i = 1; i < strs.length; i++) {
                // check
                // 1: index is not out of bound for any of the strings
                // 2: character is the same for every string
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return sb.toString();
                }
            }
            // if index character was equal in all the strings
            sb.append(c);
            // move to the next character
            index++;
        }
           
        return sb.toString();
    }
}