/*
Two pointers: Start from the beginning
Time complexity : O(n+m).
Space complexity : O(m).
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // keep the m elements of nums1 somewhere else
        int[] nums1copy = new int[m];
        System.arraycopy(nums1, 0, nums1copy, 0, m);
        
        // pointer for begining of nums1copy and nums2
        int p1 = 0;
        int p2 = 0;
        
        // set index of nums1
        int i = 0;
        
        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while (p1 < m && p2 < n) {
            
            nums1[i++] = (nums1copy[p1] < nums2[p2]) ? nums1copy[p1++] : nums2[p2++];
            
        }
        
        // if there is any leftover
        if (p1 < m) {
            System.arraycopy(nums1copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
             System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }

    }
}

/*
Two pointers / Start from the end
Time complexity : O(n+m).
Space complexity : O(1).
*/
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p1 = m - 1;
        int p2 = n - 1;
        
        int i = m + n - 1;
        
        while (p1 >= 0 && p2 >= 0) {
            nums1[i--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}