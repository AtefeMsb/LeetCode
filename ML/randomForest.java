import java.util.*;

public class RandomForest {
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

        RandomForest forest = new RandomForest(10, 1, 4, 2);
        forest.fit(samples);
        int y = forest.predict(query);
        System.out.println(y);
    }

    int numberOfTrees;
    int minSample;
    int maxDepth;
    int numberOfFeatures;
    List<DecesionTree2> trees;

    public RandomForest(int numberOfTrees, int minSample, int maxDepth, int numberOfFeatures) {
        this.numberOfTrees = numberOfTrees;
        this.minSample = minSample;
        this.maxDepth = maxDepth;
        this.numberOfFeatures = numberOfFeatures;
        trees = new ArrayList<>();
    }

    public void fit(List<int[]> samples) {
        for (int i = 0; i < numberOfTrees; i++) {
            DecesionTree2 tree = new DecesionTree2(this.minSample, this.maxDepth);
            List<int[]> bootstrappedSamples = bootstrapping(samples);
            tree.fit(bootstrappedSamples);
            trees.add(tree);
        }
    }

    public int predict(int[] sample) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < trees.size(); i++) {
            DecesionTree2 tree = trees.get(i);
            int prediction = tree.predict(sample, tree.root);

            map.put(prediction, map.getOrDefault(prediction, 0) + 1);
        }

        // pick the majority answer
        int max = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
            }
        }

        return result;
    }

    public List<int[]> bootstrapping(List<int[]> samples) {
        int samplesCount = samples.size();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < samplesCount; i++) {
            Random random = new Random();
            int id = random.nextInt(samplesCount);
            result.add(samples.get(id));
        }
        return result;
    }
}
