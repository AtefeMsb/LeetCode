// https://towardsdatascience.com/linear-regression-using-gradient-descent-97a6c8700931
/*
formula of a line: y = mx + b
loss function: Mean Square Error --> J = 1/n sigma(y - y`)^2 --> 1/n sigma(y - (mx + b))^2
Derivatives of loss function:
dm = -2/n sigma x(y - y`)
db = -2/n sigma (y - y`)
how to update current value of m and b at each iteration:
m = m - learningRate * dm
b = b - learningRate * db
*/

public class LinearRegression {
    public static void main(String[] args) {
        double[][] data = {{1, 2}, {3, 2}, {5, 6}, {8, 7}, {6,6}, {20, 2}, {10, 1}};

        // fit the model
        LinearRegression lr = new LinearRegression(0, 0, 0.001, 1000);
        lr.fit(data);
        System.out.println("m:" + lr.m + " ---- b:" + lr.b);

        // predict
        System.out.println(lr.predict(30));
    }

    // params
    double m;
    double b;
    double learningRate;
    int epochs;

    // constructor
    public LinearRegression(double m, double b, double learningRate, int epochs) {
        this.m = m;
        this.b = b;
        this.learningRate = learningRate;
        this.epochs = epochs;
    }

    // fit value of m and b using gradient descent algorithm
    public void fit(double[][] data) {
        // to avoid integer division in the formulas
        double n = data.length;

        // each epoch go through all the samples
        for (int i = 0; i < epochs; i++) {

            double sum1 = 0;
            double sum2 = 0;

            // calculate the guess and actual y for all the samples
            for (double[] d : data) {
                double x = d[0];
                double y = d[1];
                double yPredicted = (m * x) + b;

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

    public double predict(double query) {
        return this.m * query + this.b;
    }
}