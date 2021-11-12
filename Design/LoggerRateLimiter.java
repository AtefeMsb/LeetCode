class Logger {
    
    Map<String, Integer> map; 

    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // case 1). we have never seen the message before.
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        
        // case 2). we have seen the message before, and it was printed more than 10 seconds ago.
        if (timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
