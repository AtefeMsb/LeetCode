class Solution {
    
    /*
    Time complexity : O(N) time to perform N/2 swaps.
    Space complexity : O(N) it is an inplace solution but not constant space because of recursion stack.
    */
    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }
    
    private void helper(int start, int end, char[] s) {
        // base case
        if (start >= end) {
            return;
        }
        
        // swap low and high
        char temp = s[end];
        s[end] = s[start];
        s[start] = temp;
        
        // recurrence relation
        helper(start + 1, end - 1, s);
        
    } 
}
