// source: https://github.com/Suji04/ML_from_Scratch/blob/master/decision%20tree%20classification.ipynb
import java.util.*;

class Node{
    // decesion node
    int featureIndex = 0;
    int threshold = 0;
    Node left = null;
    Node right = null;
    double informationGain = 0;

    // leaf node
    int value = -1;

    public Node(int featureIndex, int threshold, Node left, Node right, double informationGain) {
            this.featureIndex = featureIndex;
            this.threshold = threshold;
            this.left = left;
            this.right = right;
            this.informationGain = informationGain;
    }

    public Node(int value) {
       this.value = value;
    }

    public String toString() {
        String result = "";
        if (value == -1) {
            result = "featureIndex:" + featureIndex + " - " + "threshold:" + threshold + " - " + "informationGain:" + informationGain;
        } else {
            result = "value:" + value;
        }
        return result;
    }

}
public class DecesionTree {
    public static void main(String[] args) {

        // create data
        List<int[]> samples = new ArrayList<>();
        samples.add(new int[]{1, 2, 0});
        samples.add(new int[]{3, 4, 0});
        samples.add(new int[]{8, 8, 1});
        samples.add(new int[]{10, 1, 0});
        samples.add(new int[]{9, 5, 1});
        samples.add(new int[]{3, 10, 0});
        samples.add(new int[]{10, 10, 0});
        samples.add(new int[]{1, 1, 0});
        samples.add(new int[]{3, 1, 0});
        int[] query = new int[]{8, 4};
        int[] query2 = new int[]{1, 1};

        DecesionTree tree = new DecesionTree(1, 4);
        Node root = tree.buildTree(samples, 0);
//        int y = tree.makePrediction(query2, root);
//        System.out.println(y);
//        tree.print(root);


    }

    public void print(Node root) {
        if (root.value != -1) {
            System.out.println(root.value);
        } else {
            System.out.println("X_" + root.featureIndex + "<=" + root.threshold + "?" + root.informationGain);
            print(root.left);
            print(root.right);
        }
    }
    int minSamples;
    int maxDepth;

    public DecesionTree(int minSamples, int depth) {
        this.minSamples = minSamples;
        this.maxDepth = maxDepth;
    }

    public Node buildTree(List<int[]> samples, int curDepth) {

        List<Integer> labels = new ArrayList<>();
        for (int[] s : samples) {
            labels.add(s[2]);
        }

        if (samples.size() < minSamples && curDepth < maxDepth) {
            // find the best split
            Util bestSplit = getBestSplit(samples);

            if (bestSplit.informationGain > 0) {
                Node leftSubtree = buildTree(bestSplit.left, curDepth + 1);
                Node rightSubtree = buildTree(bestSplit.right, curDepth + 1);
                return new Node(bestSplit.featureIndex, bestSplit.threshold, leftSubtree, rightSubtree, bestSplit.informationGain);
            }
        }

        // calculate leaf node
        int max = 0;
        int value = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int label : labels) {
            freq.put(label, freq.getOrDefault(label, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > max) {
                value = entry.getKey();
            }
        }
        return new Node(value);
    }

    public Util getBestSplit(List<int[]> samples) {
        Util bestSplit = null;
        double MaxInformationGain = Double.MIN_VALUE;
        int featureLength = samples.get(0).length - 1;
        List<List<Integer>> thresholds = possibleThreshold(samples);

        // loop all the features
        for (int i = 0; i < featureLength; i++) {
            // numbers that exist in the feature column
            List<Integer> options = thresholds.get(i);
            for (int op : options) {
                Map<String, List<int[]>> splits = split(samples, i, op);
                List<int[]> left = splits.get("left");
                List<int[]> right = splits.get("right");

                if (left.size() > 0 && right.size() > 0) {
                    List<Integer> labels = new ArrayList<>();
                    List<Integer> leftLabel = new ArrayList<>();
                    List<Integer> rightLabel = new ArrayList<>();
                    for (int[] s : samples) {
                        labels.add(s[2]);
                    }
                    for (int[] l : left) {
                        leftLabel.add(l[2]);
                    }
                    for (int[] l : left) {
                        rightLabel.add(l[2]);
                    }
                    double currentInformationGain = informationGain(labels,  leftLabel, rightLabel);
                    if (currentInformationGain > MaxInformationGain) {
                        MaxInformationGain = currentInformationGain;
                    }
                }
            }
        }

        return bestSplit;
    }

    public int makePrediction(int[] sample, Node tree) {

        // it is a leaf node
        if (tree.value != -1) return tree.value;
        int featureValue = sample[tree.featureIndex];
        if (featureValue <= tree.threshold) {
            return makePrediction(sample, tree.left);
        } else {
            return makePrediction(sample, tree.right);
        }
    }

    class Util {
        int featureIndex;
        int threshold;
        List<int[]> left;
        List<int[]> right;
        double informationGain;

        public Util(int featureIndex, int threshold, List<int[]> left, List<int[]> right, double informationGain) {
            this.featureIndex = featureIndex;
            this.threshold = threshold;
            this.left = left;
            this.right = right;
            this.informationGain = informationGain;
        }
    }

    public double informationGain(List<Integer> labels, List<Integer> leftlabel, List<Integer> rightlabel) {
        double leftWeight = leftlabel.size() / labels.size();
        double rightWeight = rightlabel.size() / labels.size();
        return gini(labels) - (leftWeight * gini(leftlabel) + rightWeight * gini(rightlabel));
    }

    public double gini(List<Integer> labels) {
        int[] counts = new int[2];
        for (int label : labels) {
            if (label == 0) {
                counts[0]++;
            } else {
                counts[1]++;
            }
        }

        return 1 - Math.pow((counts[0]/ labels.size()) + (counts[1]/ labels.size()), 2);
    }

    public Map<String, List<int[]>> split(List<int[]> samples, int featureIndex, int threshold) {
        Map<String, List<int[]>> map = new HashMap<>();
        map.put("left", new ArrayList<>());
        map.put("right", new ArrayList<>());
        for (int[] sample : samples) {
            if (sample[featureIndex] <= threshold) {
                map.get("left").add(sample);
            } else {
                map.get("right").add(sample);
            }
        }
        return map;
    }

    public List<List<Integer>> possibleThreshold(List<int[]> samples) {
        List<List<Integer>> possible = new ArrayList<>();
        int numfeatures = samples.get(0).length - 1;

        for (int i = 0; i < numfeatures; i++) {
            Set<Integer> cur = new HashSet<>();
            for (int j = 0; j < samples.size(); j++) {
                cur.add(samples.get(j)[i]);
            }
        }

        return possible;
    }
}
