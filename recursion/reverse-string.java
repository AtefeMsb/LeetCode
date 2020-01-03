class Solution {
    
    /*
    Time complexity : O(N) time to perform N/2N/2 swaps.
    Space complexity : O(N) to keep the recursion stack.
    */
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
    
    private void helper(char[] s, int low, int high) {
        // base case
        if (low >= high) {
            return;
        }
        
        // swap low and high
        char temp = s[high];
        s[high] = s[low];
        s[low] = temp;
        
        // recurrence relation
        helper(s, low + 1, high - 1);
        
    } 
}
