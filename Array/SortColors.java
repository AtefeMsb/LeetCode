/**
 * two-pass algorithm using counting sort.
 * time: O(n)
 * space: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            counts[key]++;
        }
        
        int p = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[p] = i;
                p++;
            }
        }    
    }
}

// ------------------------------------------------------
/**
 * one pass - two pointers
 * O(n)
 */
class Solution {
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        
        while (i <= p2) {
            
            if (nums[i] == 0) { // if encounter 0
                
                swap(i, p0, nums);
                p0++;
                i++;
                
            } else if (nums[i] == 2) { // if encounter 2
                
                // EDGE CASE: do not increment i because it might introduce 0 in the middle
                swap(i, p2, nums);
                p2--;
                
            } else { // if encounter 1, just skip it
                
                i++;
                
            }
        }
        
    }
}