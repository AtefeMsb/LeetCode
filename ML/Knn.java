/*
Given a new item:
    1. Find distances between new item and all other items
    2. Pick k shorter distances
    3. Pick the most common class in these k distances
    4. That class is where we will classify the new item
*/
import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    
    // the 4th value is the class label :  [0 - 1]
    int[][] samples = {{2, 3, 2, 0}, {5, 7, 5, 1}, {9, 3, 2, 1}, {3, 3, 5, 0}, {0, 9, 1, 1}, {3, 4, 5, 1}, {6, 5, 4, 0}};
    int[] query = {3, 5, 7};
    
    System.out.println(knn(samples, query, 4));
   
  }
  
  public static int knn(int[][] samples, int[] query, int k) {
    
    if (k > samples.length) {
      System.out.println("the k value is too big, maximum k value could be " + samples.length);
      return -1;
    }
    
    // 1. Find distances between new item and all other items
    // key: distance   value: class number
    TreeMap<Double, Integer> map = new TreeMap<>();
    for (int i = 0; i < samples.length; i++) {
      double distance = euclideanDistance(query, samples[i]);
      map.put(distance, samples[i][3]);
    }
        
    // 2. Pick k shorter distances
    List<Double> list = new ArrayList<>(map.keySet());
    
    List<Double> neighbors = new ArrayList<>();
    List<Integer> labels = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      double distance = list.get(i);
      neighbors.add(distance);
      labels.add(map.get(distance));
    }
    
    System.out.println("neighbors distance" + neighbors);
    System.out.println("neighbors labels" + labels);
    
    // 3. Pick the most common class in these k distances
    Map<Integer, Integer> freq = new HashMap<>();
    for (int i = 0; i < labels.size(); i++) {
      int label = labels.get(i);
      freq.put(label, freq.getOrDefault(label, 0) + 1);
    }
  
    // 4. That class is where we will classify the new item
    int max = 0;
    int result = 0;
    
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        result = entry.getKey();
      }
    }
    
    return result;
    
  }
  
  // calculates the eclidean distance between 2 points
  public static double euclideanDistance(int[] p1, int[] p2) {
    
    int sum = 0;
    for (int i = 0; i < p1.length; i++) {
      sum += Math.pow(p1[i] - p2[i], 2);
    }
    
    return Math.sqrt(sum);
    
  }
   
}
