package Snippets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    
    static List<String> subsets = new ArrayList<>();

    // wrapper function
    public static void listSubsets(String s) {
        recSubset("", s);
    }

    private static void recSubset(String sofar, String rest) {

        // base case
        if (rest == "") {
            subsets.add(sofar);
            return;
        } 

        // add to subset, remove from rest and recurse
        recSubset(sofar + rest.charAt(0), rest.substring(1));
        // don't add to subset, remove from rest and recurse 
        recSubset(sofar, rest.substring(1));
    }

    public static void main(String[] args) {
        listSubsets("abc");
        System.out.println(subsets.toString());
    }
}
