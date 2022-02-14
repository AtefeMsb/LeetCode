class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        if (matrix == null && matrix.length == 0) {
            return nums;
        }
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;
        
        while (nums.size() < size) {
            
            for (int i = left; i <= right && nums.size() < size; i++) {
                nums.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom && nums.size() < size; i++) {
                nums.add(matrix[i][right]);
            }
            right--;
            
            for (int i = right; i >= left && nums.size() < size; i--) {
                nums.add(matrix[bottom][i]);
            }
            bottom--;
            
            for (int i = bottom; i >= top && nums.size() < size; i--) {
                nums.add(matrix[i][left]);
            }
            left++;
            
        } 
        
         return nums;
    }
}
// -------------------------------------------------------------
// easier solution
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;
            
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;
            
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }
        
        return res;
    }
    
}