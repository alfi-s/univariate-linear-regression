import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    /*
     * Reads the data from a given csv file
     */
    public static List<List<Double>> dataFrom(String fileName) {
        List<List<Double>> output = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = reader.readLine()) != null) {
                String[] rawValues = line.split(",");
                for(int i = 0; i < rawValues.length; i++) {
                    if(i >= output.size()) output.add(new ArrayList<>());
                    output.get(i).add(Double.parseDouble(rawValues[i]));
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    /*
     * Generates the points to plot a function.
     */
    public static List<List<Double>> plotFunction(double min, double max, double step, HypothesisFunction f_x){
        List<List<Double>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        output.add(new ArrayList<>());

        for(double x = min; x <= max; x += step) {
            output.get(0).add(x);
            output.get(1).add(f_x.evaluate(x));
        }

        return output;
    }
}
