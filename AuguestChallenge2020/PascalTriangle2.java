package AuguestChallenge2020;

// Dynamic Programming
class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        // only keep the last row 
        List<Integer> result = new ArrayList<>();
        
        if (rowIndex < 0) return result;
        
        result.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            
            List<Integer> tempRow = new ArrayList<>();
            
            tempRow.add(1);
            
            for (int j = 1; j < i; j++) {
                tempRow.add(result.get(j - 1) + result.get(j));
            }
            tempRow.add(1);  
            
            result = tempRow;
        }
        
        return result;
    }
}