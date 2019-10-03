class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        // create a 2d arraylist
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) return triangle;
        
        // set the first row as default including just one element 
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        // add the first row to triangle
        triangle.add(first_row);

        // for each row (1-numRows) 
        for (int i = 1; i < numRows; i++) {
            // create an arraylist to add to triangle
            List<Integer> row = new ArrayList<>();
            // add element one always as 1
            row.add(1);
            // retrieve previous row to use for current row calculation
            List<Integer> pre_row = triangle.get(i - 1);
            
            for (int j = 1; j < i; j++) {
                
                int val = pre_row.get(j) + pre_row.get(j - 1);
                row.add(val);
                
            }
            // add last element always as 1
            row.add(1);
            triangle.add(row);
        }
      
       return triangle; 
    }
}
