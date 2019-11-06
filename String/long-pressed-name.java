class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        if (typed.length() < name.length()) { return false; }
        
        int i = 0; // traversing name
        int j = 0; // traversing typed
        
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;  
        }
        return i == name.length();
    }
}
