public class GradientDescent {

    static final String DATA_FILE = "data/MacdonellDF.csv";

    public static void main(String[] args) {

        // Our dataset.
        double[][] data = Data.dataFrom(DATA_FILE);

        // Number of iterations we want to run through the algorithm
        final int epochs = 100;

        // We want to predict h(x) = w1 * x + w0
        double w1 = 0;
        double w0 = 0;

        // Learning rate
        double alpha = 0.01;

        // GRADIENT DESCENT ALGORITHM FOR LEAST MEAN SQUARES
        for(int i = 0; i < epochs; i++) {

            double cost = 0;

            for(int j = 0; j < data.length; j++) {

                double x_j = data[j][0];
                double y_j = data[j][1];

                double prediction = (w1 * x_j) + w0;

                // cost += (y_j - h(x))^2
                cost += (y_j - prediction) * (y_j - prediction);

                // Update the parameters for our equation.
                w1 += alpha * (y_j - prediction) * x_j;
                w0 += alpha * (y_j - prediction);

            }

            System.out.println("Current Cost: " + cost);
        }

        System.out.println("Final Equation: h(x) = (" + w1 + " * x) + " + w0);
    }

}
