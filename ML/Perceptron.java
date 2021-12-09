import java.util.ArrayList;
import java.util.List;

public class Perceptron {

    public static void main(String[] args) {
        // create data
        List<int[]> samples = new ArrayList<>();
        samples.add(new int[]{30, 0});
        samples.add(new int[]{15, 0});
        samples.add(new int[]{5, 0});
        samples.add(new int[]{10, 0});
        samples.add(new int[]{5, 0});
        samples.add(new int[]{15, 1});
        samples.add(new int[]{20, 1});
        samples.add(new int[]{25, 1});
        samples.add(new int[]{30, 1});
        samples.add(new int[]{30, 1});

        Perceptron p = new Perceptron(0.001, 10);
        p.fit(samples);
        System.out.println(p.predict(4));

    }

    double weight;
    double bias;
    double learningRate;
    int epochs;

    public Perceptron(double learningRate, int epochs) {
        this.weight = 0;
        this.bias = 0;
        this.learningRate = learningRate;
        this.epochs = epochs;
    }

    // Activation Function
    public int stepFunction(double x) {
        return (x >= 0) ? 1 : 0;
    }

    public void fit(List<int[]> samples) {
        for (int i = 0; i < epochs; i++) {

            /* FOR EACH SAMPLE
            delta = learningRate * (y - yPredicted)
            update rule :
                weight = weight + delta * x
                bias = bias + delta;
            */

            int[] s = samples.get(i);
            int x = s[0];
            int y = s[1];
            double linearOutput = x * weight + bias;
            int yPredicted = stepFunction(linearOutput);

            double delta = learningRate * (y - yPredicted);

            weight = weight + delta * x;
            bias = bias + delta;

        }
    }

    public int predict(int x) {
        return stepFunction((weight * x) + bias);
    }

}
