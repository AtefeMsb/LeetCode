class Solution {
    public String[] reorderLogFiles(String[] logs) {
       
       Comparator<String> myComp = new Comparator<String>() {
        
            @Override
            public int compare(String log1, String log2) {

                int index1 = log1.indexOf(" ");
                String id1 = log1.substring(0, index1);
                String main1 = log1.substring(index1 + 1);

                int index2 = log2.indexOf(" ");
                String id2 = log2.substring(0, index2);
                String main2 = log2.substring(index2 + 1);

                boolean isDigit1 = Character.isDigit(main1.charAt(0));
                boolean isDigit2 = Character.isDigit(main2.charAt(0));

                // case 1: both logs are letter log
                if (isDigit1 == false && isDigit2 == false) {

                    int cmp = main1.compareTo(main2);
                    if (cmp == 0) {
                        return id1.compareTo(id2);
                    } 

                    return cmp; 
                }

                // case 2: one of the logs is digit log
                int temp = 0;
                if (isDigit1 == false && isDigit2 == true) {
                    temp = -1;
                } else if (isDigit1 == true && isDigit2 == false) {
                    temp = 1;
                } else if (isDigit1 == true && isDigit2 == true) {
                    temp = 0;
                }
            
                return temp;
            }
       };
        
        Arrays.sort(logs, myComp);
        return logs;
        
    }
}