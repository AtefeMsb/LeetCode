class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // count number of occurence of each pair
        for (int[] d : dominoes) {
            // this formula changes [1, 2] abd [2, 1] into 12
            int key = Math.min(d[0],d[1]) * 10 + Math.max(d[0],d[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // count number of pairs
        for (int v : map.values()) {
            count += v * (v - 1) / 2;
        }
        return count;
    }
}
