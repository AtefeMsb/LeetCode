class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        
        int n = A.length;
        LinkedList<Integer> result = new LinkedList<Integer>();
        int carry = 0;
        int lastIndex = n - 1;
        
        // start from left side of both: array and number K
        while (lastIndex >= 0 && K > 0) {
            
            int r = A[lastIndex] + (K % 10) + carry;
            carry = 0;
            if (r > 9) {
                carry = r / 10; 
            }
            
            result.addFirst(r % 10);
            
            lastIndex--;
            K = K / 10;
        } //while
        
        // if still digits left in the array
        while (lastIndex >= 0) {
            int r = A[lastIndex] + carry;
            carry = 0;
            if (r > 9) {
                carry = r / 10; 
            }
            result.addFirst(r % 10);
            lastIndex--;
        }
        
        // if still digits left in K
        while (K > 0) {
            
            int r = (K % 10) + carry;
            carry = 0;
            if (r > 9) {
                carry = r / 10; 
            }
            
            result.addFirst(r % 10);
            K = K / 10;
        }

        // if carry wasnt resolve till the last digit and overflowed
        if (carry > 0) {
          result.addFirst(carry);  
        }
     
        return result;
    }
    
}
