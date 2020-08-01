package TopInterview;

public class ReverseString {

    public void reverseString(char[] s) {
        
        int start = 0;
        int end = s.length - 1;
        
        while (start < end) {
             // swap the characters
            Character temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            
            start++;
            end--;
        }
    }
}