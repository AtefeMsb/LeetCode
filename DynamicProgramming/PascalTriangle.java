package DynamicProgramming;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) return triangle;
       
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        // adds the rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            
            // always first element is 1
            currRow.add(1);
            
            // fill up the row
            for (int j = 1; j < i ; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // always last element is 1
            currRow.add(1);
        
            triangle.add(currRow);
         }
        
        
        System.out.println(triangle);
        
        return triangle;
    }
}