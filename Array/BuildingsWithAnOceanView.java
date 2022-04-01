class Solution {
    public int[] findBuildings(int[] heights) {
        
        List<Integer> res = new ArrayList<>();
        int max = -1;
  
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = Math.max(max, heights[i]);
                res.add(i);
            }  
        }
        
        int[] out = new int[res.size()];
        int i = res.size() - 1;
        for (int num : res) {
            out[i] = num;
            i--;
        }
        
        return out;
    }
}