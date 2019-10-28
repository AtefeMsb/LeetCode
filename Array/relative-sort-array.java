class Solution {
public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        // array to record each item frequency ( for ex: the value in index 2 means how many 2s exist)
        int[] cnt = new int[1001];
        int[] ans = new int[arr1.length];
    
        // Count each number in arr1.
        for (int i : arr1) {                    
            cnt[i] += 1;
        }
    
        // Sort the common numbers in both arrays by the order of arr2.
        int k = 0;
        for (int i : arr2) {                 
            while (cnt[i] > 0) {
                ans[k] = i; 
                k++;
                cnt[i]--;
            }
        }
        // Sort the numbers only in arr1 - any index that its values not zero yet
        for (int i = 0; i < 1001; i++) {        
            while (cnt[i] > 0) {
                ans[k] = i;
                k++;
                cnt[i]--;
            }
        }
        return ans;
    }
}
