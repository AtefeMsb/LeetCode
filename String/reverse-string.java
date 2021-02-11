// two pointers
class Solution {
    public void reverseString(char[] s) {
        
        int len = s.length;
        
        int low = 0;
        int high = len - 1;
        
        while (low < high) {
            // swap the two character
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            
            low++;
            high--;
        }  
    }
}
