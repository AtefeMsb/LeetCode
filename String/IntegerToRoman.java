// source: https://www.youtube.com/watch?v=yzB4M-UXqgI
class Solution {
    class Numeral {
        String symbol;
        int value;
        public Numeral(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }
    
    public String intToRoman(int num) {
        
        String roman = "";
        Numeral[] numerals = {
            new Numeral("M", 1000),
            new Numeral("CM", 900),
            new Numeral("D", 500),
            new Numeral("CD", 400),
            new Numeral("C", 100),
            new Numeral("XC", 90),
            new Numeral("L", 50),
            new Numeral("XL", 40),
            new Numeral("X", 10),
            new Numeral("IX", 9),
            new Numeral("V", 5),
            new Numeral("IV", 4),
            new Numeral("I", 1)  
        };
    
        // go through all the numerals from the latrgest to smallest
        for (Numeral numeral : numerals) {
            int numberOfSymbols = num / numeral.value;
            
            // repeat the symbol, if its repeat number is not zero
            if (numberOfSymbols != 0) {
                for (int i = 0; i < numberOfSymbols; i++) {
                    roman = roman + numeral.symbol;
                }
                // remove the most left digit
                num = num % numeral.value;
            }
        }
        
        return roman;
        
    }
}