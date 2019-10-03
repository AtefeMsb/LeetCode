class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // fill the array from the end insetad of start
        int right = n + m - 1;
        // last index of each array
        m = m - 1;
        n = n - 1;
        
        // begining of any array hasn't been reach
        while (m >= 0 && n >= 0) {
            
            if (nums2[n] > nums1[m]) {
                nums1[right] = nums2[n];
                n--;
                right--;
            } else {
                nums1[right] = nums1[m];
                m--;
                right--;
            } 
        }
        
        // the case that all elements from nums1 are finished and there are some elemnts left in nums2
         while (n >= 0){
            nums1[right] = nums2[n];
            right--;
            n--;
        }
    }
}
