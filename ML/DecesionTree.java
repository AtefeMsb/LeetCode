// source: https://github.com/Suji04/ML_from_Scratch/blob/master/decision%20tree%20classification.ipynb

import java.util.*;

class Node{
    // decesion node
    int featureIndex = 0;
    double threshold = 0;
    Node left = null;
    Node right = null;
    double informationGain = 0;

    // leaf node
    int value = -1;

    public Node(int featureIndex, double threshold, Node left, Node right, double informationGain) {
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
public class DecesionTree2 {
    public static void main(String[] args) {

        // create data
        List<int[]> samples = new ArrayList<>();
        samples.add(new int[]{1, 30, 0});
        samples.add(new int[]{1, 15, 0});
        samples.add(new int[]{1, 5, 0});
        samples.add(new int[]{0, 10, 0});
        samples.add(new int[]{0, 5, 0});
        samples.add(new int[]{0, 15, 1});
        samples.add(new int[]{0, 20, 1});
        samples.add(new int[]{0, 25, 1});
        samples.add(new int[]{0, 30, 1});
        samples.add(new int[]{0, 30, 1});

        int[] query = new int[]{0, 11};
        int[] query2 = new int[]{1, 40};

        DecesionTree2 tree = new DecesionTree2(1, 4);
        tree.fit(samples);
        System.out.println(tree.root);

        int y = tree.predict(query2, tree.root);
        System.out.println(y);
        tree.print(tree.root);
    }

    int minSamples;
    int maxDepth;
    Node root;

    public DecesionTree2(int minSamples, int maxDepth) {
        this.minSamples = minSamples;
        this.maxDepth = maxDepth;
        this.root = null;
    }

    public void fit(List<int[]> samples) {
        root = builtTree(samples, 0);
    }

    public Node builtTree(List<int[]> samples, int curDepth) {

        List<Integer> labels = new ArrayList<>();
        for (int[] s : samples) {
            labels.add(s[2]);
        }

        // stopping criteria
        if (samples.size() > minSamples && curDepth < maxDepth) {
            // find the best split
            Util bestSplit = getBestSplit(samples);

            if (bestSplit.informationGain > 0) {
                Node leftSubtree = builtTree(bestSplit.left, curDepth + 1);
                Node rightSubtree = builtTree(bestSplit.right, curDepth + 1);
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
        Util bestSplit = new Util(0, 0, null, null, 0);
        double MaxInformationGain = Double.MIN_VALUE;
        int featureCount = samples.get(0).length - 1;  // -1 because the last item in sample is the label
//        List<List<Integer>> thresholds = possibleThreshold(samples);

        for (int i = 0; i < featureCount; i++) {

            // get all the thresholds
            Set<Integer> options = new HashSet<>();
            for (int[] s : samples) {
                options.add(s[i]);  // add the feature value
            }

            // find the best split
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

                        // update the return object Util
                        bestSplit.featureIndex = i;
                        bestSplit.threshold = op;
                        bestSplit.left = left;
                        bestSplit.right = right;
                        bestSplit.informationGain = currentInformationGain;

                    }
                }
            }
        }

        return bestSplit;
    }

    // split the samples list based on the featureIndex and threshold into left and right
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


    // return obj for getBestSplit function
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
        double leftWeight = (double)(leftlabel.size() / labels.size());
        double rightWeight = (double)(rightlabel.size() / labels.size());
        return gini(labels) - ( (leftWeight * gini(leftlabel)) + (rightWeight * gini(rightlabel)) );
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

        return 1 - Math.pow((double)(counts[0]/ labels.size()) + (double)(counts[1]/ labels.size()), 2);
    }


    public int predict(int[] sample, Node tree) {

        // it is a leaf node
        if (tree.value != -1) return tree.value;
        int featureValue = sample[tree.featureIndex];
        if (featureValue <= tree.threshold) {
            return predict(sample, tree.left);
        } else {
            return predict(sample, tree.right);
        }
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
}