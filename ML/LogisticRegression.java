// source: https://www.youtube.com/watch?v=JDU3AzH3WKg
// source: https://github.com/python-engineer/MLfromscratch/blob/master/mlfromscratch/logistic_regression.py

public class LogisticRegression {
    public static void main(String[] args) {
        double[][] data = {{10, 1}, {18, 0}, {3, 0}, {2, 0}, {6,1}, {20, 1}, {18, 1}};

        LogisticRegression lr = new LogisticRegression(0, 0, 0.001, 100);
        lr.fit(data);
        System.out.println("m:" + lr.m + " ---- b:" + lr.b);

        System.out.println(lr.predict(1));
    }
    double m;
    double b;
    double learningRate;
    int epochs;

    public LogisticRegression(double m, double b, double learningRate, int epochs) {
        this.m = m;
        this.b = b;
        this.learningRate = learningRate;
        this.epochs = epochs;
    }
    public void fit(double[][] data) {
        // to avoid integer division in the formulas
        double n = data.length;

        double sum1 = 0;
        double sum2 = 0;

        // gradient descent
        for (int i = 0; i < epochs; i++) {

            for (double[] d : data) {
                double x = d[0];
                double y = d[1];
                double yPredicted = sigmoid((m * x) + b);

                sum1 += x * (y - yPredicted);
                sum2 += y - yPredicted;
            }

            // calculate the derivative
            double dm = (-2/n) * sum1;
            double db = (-2/n) * sum2;

            // update m and b
            m = m - (learningRate * dm);
            b = b - (learningRate * db);
        }

    }

    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public int predict(double query) {
        double linear = (m * query) + b;
        double predictedProbability = sigmoid(linear);
        return (predictedProbability > 0.5) ? 1 : 0;

    }
}