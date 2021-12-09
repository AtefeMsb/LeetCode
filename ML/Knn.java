import java.util.*;
/* Given a new item:
    1. Find distances between new item and all other items
    2. Pick k shorter distances
    3. Pick the most common class in these k distances
    4. That class is where we will classify the new item */

public class Knn {
    public static void main(String[] args) {
        // the 4th value is the class label :  [0 - 1]
        List<int[]> samples = new ArrayList<>();
        samples.add(new int[]{2, 3, 2, 0});
        samples.add(new int[]{5, 7, 5, 1});
        samples.add(new int[]{9, 3, 2, 1});
        samples.add(new int[]{3, 3, 5, 0});
        samples.add(new int[]{0, 9, 1, 1});
        samples.add(new int[]{3, 4, 5, 1});
        samples.add(new int[]{6, 5, 4, 0});
        int[] query = {3, 5, 7};

        Knn knn = new Knn(3, samples);
        System.out.println(knn.predict(query));
    }

    int k;
    List<int[]> samples ;

    public Knn(int k, List<int[]> samples) {
        this.k = k;
        this.samples = samples;
    }


    public int predict(int[] query) {

        // 1. Find distances between new item and all other items
        // key: distance   value: class number
        TreeMap<Double, Integer> map = new TreeMap<>();
        for (int i = 0; i < samples.size(); i++) {
            int[] sample = samples.get(i);
            double distance = euclideanDistance(query, sample);
            map.put(distance, sample[3]);
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

        System.out.println("neighbors' distances" + neighbors);
        System.out.println("neighbors' labels" + labels);
        
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

    // calculates the Euclidean distance between 2 points
    public static double euclideanDistance(int[] p1, int[] p2) {
        int sum = 0;
        for (int i = 0; i < p1.length; i++) {
            sum += Math.pow(p1[i] - p2[i], 2);
        }
        return Math.sqrt(sum);
    }
}