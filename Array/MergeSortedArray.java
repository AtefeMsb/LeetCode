/**
 * TWO POINTERS: start from the end
 * time: O(m + n)
 * space: O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;
        
        // And move i backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int i = m + n - 1; i >= 0; i--) {
            
            if (p2 < 0) {
                break;
            }
            
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
        
    }
}
// ----------------------------------------
/**
 * use extra space
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] nums3 = new int[n + m];
        int i = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        
        while (ptr1 < m && ptr2 < n) {
            
            if (nums1[ptr1] < nums2[ptr2]) {
                nums3[i] = nums1[ptr1];
                ptr1++;
            } else {
                nums3[i] = nums2[ptr2];
                ptr2++;
            }
            i++;
            
        }
        
        while (ptr1 < m) {
            nums3[i] = nums1[ptr1];
            i++;
            ptr1++;
        } 
        while (ptr2 < n) {
            nums3[i] = nums2[ptr2];
            i++;
            ptr2++;
        }
        
        for (int j = 0; j < n + m; j++) {
            nums1[j] = nums3[j];
        }
    }
}