package AuguestChallenge2020;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    
    Map<String, Integer> timeTable;

    /** Initialize your data structure here. */
    public Logger() {
        timeTable = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if (timeTable.containsKey(message)) {
            
            if (timestamp - timeTable.get(message) < 10) {
                return false;
            } else {
                timeTable.put(message, timestamp);
                return true;
            }
            
        } else {
            
            timeTable.put(message, timestamp);
        }
    
        return true;
    }
    
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */