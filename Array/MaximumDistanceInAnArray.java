class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        int res = 0;
        
        // get min and m,ax val;ue of the first array
        int min_val = arrays.get(0).get(0);
        int max_val = arrays.get(0).get(arrays.get(0).size() - 1);
                    
        // start from the second array
        for (int i = 1; i < arrays.size(); i++) {
            
            res = Math.max(res,
                           
                           Math.max(
                           // current array max minus general min_val
                           Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min_val),
                           
                           // general max_val minus current array min
                           Math.abs(max_val - arrays.get(i).get(0))
                               )
                           );
            
            min_val = Math.min(min_val, arrays.get(i).get(0));
            max_val = Math.max(max_val, arrays.get(i).get(arrays.get(i).size() - 1));
  
        }
      
        
        return res;
        
    }
}