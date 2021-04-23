package Snippets;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    
    static List<String> permutations = new ArrayList<>();

    // wrapper function
    public static void listPermutation(String s) {
        recPermute("", s);
    }

    private static void recPermute(String sofar, String rest) {

        // base case
        if (rest == "") {
            permutations.add(sofar);
            return;
        } 

        for (int i = 0; i < rest.length(); i++) {
            String next = sofar + rest.charAt(i);
            String remaining = rest.substring(0, i) + rest.substring(i + 1);
            recPermute(next, remaining);
        }
    
    }




    public static void main(String[] args) {
        listPermutation("apple");
        System.out.println(permutations.toString());
    }
}
