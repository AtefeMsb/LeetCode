class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        
        System.out.println(Arrays.toString(prefixSum));
        
        // get odd length substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j = j + 2) {
                res += prefixSum[j] - prefixSum[i];
            }
        }
        
        return res;
        
    }
}