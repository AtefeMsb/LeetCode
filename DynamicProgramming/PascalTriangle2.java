package DynamicProgramming;


class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> row = new ArrayList<>();
        
        row.add(1);
        
        if (rowIndex == 0) {return row;}
        
        for (int i = 1; i <= rowIndex; i++) {
            
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            
            for (int j = 1; j < i; j++) {
                
                int sum = row.get(j - 1) + row.get(j);
                currentRow.add(sum);
                
            }
            
            currentRow.add(1);
            
            row = currentRow;
        }
        
        return row;
        
    }
}