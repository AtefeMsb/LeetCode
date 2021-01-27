package BinarySearch;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        
        int left = 1;
        int right = n;
        int pick = 1;
        
        while (left <= right) {
            pick = left + (right - left) / 2;
            int result = guess(pick);
            
            // my pick < question pick
            if (result == -1) {
               right = pick - 1;
                
            // my pick > question pick
            } else if (result == 1) {
                left = pick + 1;
                
            // my pick == question pick
            } else if (result == 0) {
                break;
            }
        }
        
        return pick;
        
        
    }
}