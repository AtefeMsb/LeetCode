package AuguestChallenge2020;

class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        
        int left = 0;
        int right = A.length - 1;
        
        while (left < right) {
            
            if (left < right && A[left] % 2 == 0) left++;
            if (left < right && A[right] % 2 == 1) right--;
            
            // swap left and right
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        
        return A;
    }
}