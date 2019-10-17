/*
start from the begining and when 
seeing 0 move one to the front
seeing 1 move two to the front
when reached to the end (either on the last element or passed it)
if land on the last element that is when the last one is a one bit char
*/
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
    
        while (i < n - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == n - 1;
    }
}
