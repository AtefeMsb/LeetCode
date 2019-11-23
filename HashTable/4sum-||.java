class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for(int k = 0; k < A.length; k++) {
            for(int l = 0; l < B.length; l++) {
                int sum = -(A[k] + B[l]);
                if (map.containsKey(sum)) {
                    result += map.get(sum);
                }
            }
        }
        return result;
    }
}
