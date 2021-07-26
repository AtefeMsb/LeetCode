/** Algorithm: Knuth shuffle
* time: O(n)
*/
class Solution {

    private int[] nums;
    private Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        int[] randNums = new int[nums.length];
        
        // copy nums into randNums
        for (int i = 0; i < nums.length; i++) {
            randNums[i] = nums[i];
        }
        
        // find random index for each index in the array
        for (int i = 0; i < randNums.length; i++) {
            int randIndex = rand.nextInt(nums.length - i) + i;
            
            // swap randIndex with i
            int temp = randNums[i];
            randNums[i] = randNums[randIndex];
            randNums[randIndex] = temp;
        }
        
        return randNums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */