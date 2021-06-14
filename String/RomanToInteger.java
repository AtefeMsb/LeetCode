class Solution {  
  public int romanToInt(String s) {
      int result = 0;
      
      Map<String, Integer> numerals = new HashMap<>();
      numerals.put("M", 1000);
      numerals.put("CM", 900);
      numerals.put("D", 500);
      numerals.put("CD", 400);
      numerals.put("C", 100);
      numerals.put("XC", 90);
      numerals.put("L", 50);
      numerals.put("XL", 40);
      numerals.put("X", 10);
      numerals.put("IX", 9);
      numerals.put("V", 5);
      numerals.put("IV", 4);
      numerals.put("I", 1);
      
      int i = 0;
      for (i = 0; i < s.length() - 1; i++) {
          
          String first = Character.toString(s.charAt(i));
          String second = Character.toString(s.charAt(i + 1));
          String both = first + second;
          // get both character if possible
          if (numerals.containsKey(both)) {
              result += numerals.get(both); 
              i++;
              // if not only one character
          } else {
              result += numerals.get(first);
          } 
      }
  
      // add the last character if it has not been calculated
      if (i < s.length()) {
          String last = Character.toString(s.charAt(s.length() - 1));
          result += numerals.get(last);
      }
      return result;
  }
}