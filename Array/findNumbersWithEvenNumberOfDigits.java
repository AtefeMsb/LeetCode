package Array;

public class findNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        
        for (int num : nums) {
            if (digitNumber(num) % 2 == 0) {
                evenCount += 1;
            }
        }
        
        return evenCount;
    }
    
    private int digitNumber(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count += 1;
        }
        
        return count;
    }
}
