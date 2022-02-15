class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    public String buildString(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        
        return String.valueOf(stack);
    }
}

// -------------------------------------
/**
 * two pointers
 * time: O(n)
 * space: O(1)
 */

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        
        while (i >= 0 || j >= 0) {
            
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    i--;
                    skipS++;
                } else if (skipS > 0) { // skip the regular character
                    i--;
                    skipS--;
                } else {    // break the regular character when there is no skip
                    break;
                }
            }
            
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    j--;
                    skipT++;
                } else if (skipT > 0) { 
                    j--;
                    skipT--;
                } else {
                    break;
                }
            }
            
            // if two actual character are diffrent
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            
            // if one of the string is already empty
            if ((i >= 0) != (j >= 0)) return false;
            
            // move on to the next character (backward)
            i--;
            j--;   
        }
        
        return true;
    }
}