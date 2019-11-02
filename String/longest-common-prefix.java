/* Horizontal scanning
1- set prefix to the first element in strs array
2- each iteration using indexOf tries to find the current prefix in current string
3- if it was not find take one character away
4- if prefix became empty means there is no common prefix exist
*/
class Solution { 
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {return "";}

        String prefix = strs[0];
    
        for (int i = 1; i < strs.length; i++) {
            // while we can not find the prefix at the begining of the current string
            while (strs[i].indexOf(prefix) != 0) {            
                // String substring(begIndex, endIndex)
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        }
        return prefix;
    }
}
