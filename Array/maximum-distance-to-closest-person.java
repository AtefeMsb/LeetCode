/*
Use two pointers:

1- If the current value is "0", keep going forward.
2- Left pointer points to the position of left "1" and right pointer points to the position of right "1". Keep updating two pointers and calculate the max distance.
3- Be careful of two situations: seats[0] is 0 and seats[len - 1] is 0. Ex: 00101000. edge cases.
*/
class Solution {
        public int maxDistToClosest(int[] seats) {
        int left = -1;
        int maxDistance = 0;
        int n = seats.length;
            
        for(int right = 0; right < n ; right++) {
            if(seats[right] == 1) {
                if(left == -1) {
                    //handles edge case when it leads with 0. 
                    maxDistance = Math.max(maxDistance, right); 
                } else {
                    //when your seat is inbetween 1s, you need to find half point between the two so you divide by 2
                    maxDistance = Math.max(maxDistance, (right- left) /2); 
                }
                
                left = right;
            }
        }
            
        if (seats[n-1] == 0) {
            //handles edge case when ends with 0.
            maxDistance = Math.max(maxDistance, (n-1-left)); 
        }
        return maxDistance;
    }
}
