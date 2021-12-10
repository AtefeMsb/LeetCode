import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // generate random point between min and max
    public static Point createRandomPoint(int min, int max) {
        Random r = new Random();
        double x = min + (max - min) * r.nextDouble();
        double y = min + (max - min) * r.nextDouble();
        return new Point(x,y);
    }

    // eucliedan distance
    public static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Kmean {
    public static void main(String[] args) {

        // create the input
        List<Point> points = new ArrayList<>();
        Point p1 = new Point(4, 2);
        points.add(p1);
        p1 = new Point(5, 2);
        points.add(p1);
        p1 = new Point(4, 1);
        points.add(p1);
        p1 = new Point(1, 2);
        points.add(p1);
        p1 = new Point(2, 2);
        points.add(p1);
        p1 = new Point(1, 4);
        points.add(p1);
        p1 = new Point(100, 100);
        points.add(p1);
        p1 = new Point(8, 8);
        points.add(p1);
        p1 = new Point(9, 9);

        Kmean kmean = new Kmean(3, 100, points);
        kmean.predict();

    }

    int k;
    int numberIteration;
    List<Point> points;

    public Kmean(int k, int numberIteration, List<Point> points) {
        this.k = k;
        this.numberIteration = numberIteration;
        this.points = points;
    }

    public void predict() {

        // initialization
        // generate random centroids for start
        List<Point> centroids = new ArrayList<>();
        int min = 0;
        int max = 10;
        for (int i = 0; i < k; i++) {
            centroids.add(Point.createRandomPoint(min, max));
        }

        boolean finish = false;
        int iterations = 0;

        while (iterations < this.numberIteration) {

            // initialize the k clusters with empty list
            List<List<Point>> clusters = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                List<Point> list = new ArrayList<>();
                clusters.add(list);
            }

            // 1. assign each point to a cluster
            assignCluster(clusters, centroids, points);

            // 2. recompute centroid for each cluster (mean of all points in that cluster)
            List<Point> newCentroids = calculateCentroid(clusters);

            logging(clusters, centroids);

            // check for convergence
            if (isConverged(centroids, newCentroids, clusters)) {
                break;
            }

            System.out.println("-------------------------");

            centroids = newCentroids;
            iterations++;

        } // end of while
    }

    public void assignCluster(List<List<Point>> clusters, List<Point> centroids,List<Point> points) {
        for (Point p : points) {
            double distance = Integer.MAX_VALUE;
            int clusterId = 0;

            for (int i = 0; i < centroids.size(); i++) {
                double cur = Point.calculateDistance(p, centroids.get(i));
                if (cur < distance) {
                    distance = cur;
                    clusterId = i;
                }
            }

            clusters.get(clusterId).add(p);
        }
    }

    public List<Point> calculateCentroid(List<List<Point>> clusters) {
        List<Point> newCentroids = new ArrayList<>();
        for (List<Point> list : clusters) {
            Double sumX = 0.0;
            Double sumY = 0.0;
            int count = list.size();
            for (Point p : list) {
                sumX += p.x;
                sumY += p.y;
            }
            newCentroids.add(new Point((double)(sumX/count), (double)(sumY/count)));
        }
        return newCentroids;
    }

    public boolean isConverged(List<Point> oldCentroid, List<Point> newCentroid, List<List<Point>> clusters) {
        double diff = 0;
        for (int i = 0; i < oldCentroid.size(); i++) {
            // for empty clusters
            if (clusters.get(i).size() == 0) return false;
            diff += Point.calculateDistance(oldCentroid.get(i), newCentroid.get(i));
        }

        System.out.println("diff: " + diff);

        if (diff == 0) {
            return true;
        }

        return false;
    }

    public void logging(List<List<Point>> clusters, List<Point> centroids) {
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("cluster id: " + (i + 1));

            if (clusters.get(i).size() == 0) {
                System.out.println("empty cluster");
                continue;
            }

            System.out.println("centroid: " + centroids.get(i));
            for (Point p : clusters.get(i)) {
                System.out.print(p);
            }
            System.out.println();
        }
    }
}