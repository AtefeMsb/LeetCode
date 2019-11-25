public class ValidWordAbbr {
    private final Map<String, Boolean> abbrDict = new HashMap<>();
    private final Set<String> dict;

    public ValidWordAbbr(String[] dictionary) {
        // nserting the entire dictionary into a set
        dict = new HashSet<>(Arrays.asList(dictionary));
        
        // fill the map.    key: abbr   value: true if exist more than once
        for (String s : dict) {
            String abbr = toAbbr(s);

            // if already seen, makes it false
            if (abbrDict.containsKey(abbr)) {
                abbrDict.put(abbr, false);
            } else {
                abbrDict.put(abbr, true);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Boolean hasAbbr = abbrDict.get(abbr);
        
        // return hasAbbr == null || (hasAbbr && dict.contains(word));
        
        // unique if : exist in the dictionary && boolean value in map is true (means it is unique)
        if (dict.contains(word) && hasAbbr) {
            return true;
            // a new word from outside dictionary
        } else if (hasAbbr == null) {
            return true;
        }
        return false;
    }

    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
