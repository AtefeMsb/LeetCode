package AuguestChallenge2020;

class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        
        int result = 0;
        
        for (char c : s.toCharArray()) {
            /*
            how to get the number value of a character without building an alphabet mapping?
            You can do this by converting a character to its ASCII value and subtracting ASCII
            value of character 'A' from that value. By doing so, you will get results from 0 (for A)
            to 25 (for Z). Since we are indexing from 1, we can just add 1 up to the result.
            */
            result = result * 26 + (c - 'A' + 1);
        }
                
        return result;
        
    }
}