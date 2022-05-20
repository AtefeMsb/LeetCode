class Solution {
    public String nextPalindrome(String num) {
        
        // convert the first half to int array
        int halfLen = num.length() / 2;
        int[] arr = new int[halfLen];
        for (int i = 0; i < halfLen; i++) {
            arr[i] = num.charAt(i) - '0';
        }
        
        // if the first half is already the largest number, meaning it has no next permutation, return ""
        if (nextPermutation(arr) == false) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n);
        }
        
        // if the num size is odd, we add the mid element as well
        return (num.length() % 2 == 0) ? sb.toString() + sb.reverse().toString() : 
                                         sb.toString() + num.substring(halfLen, halfLen + 1) + sb.reverse().toString();
    }
    
    // find the next permutation of an int array
    private boolean nextPermutation(int[] arr) {
        
        int pivot = findPrefix(arr) - 1;
        
        if (pivot == -1) return false;
        
        if (pivot != -1) {
            int nextPivot = findNextLargest(arr, arr[pivot]);
            swap(arr, pivot, nextPivot);
        }
      
        reverse(arr, pivot + 1);
        return true;
    }
    
    private void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    
    // find the first largest number in suffix
    private int findNextLargest(int[] arr, int pivot) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > pivot) {
                return i;
            }
        }
        return -1;  
    }
    
    // find the pivot, where after that array is in decresing order
    private int findPrefix(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                return i;
            }
        }
         return 0;
    }
}