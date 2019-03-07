import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    public static double[][] dataFrom(String fileName) {
        List<double[]> output = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = reader.readLine()) != null) {
                String[] rawValues = line.split(",");
                double[] values = new double[rawValues.length];
                for(int i = 0; i < rawValues.length; i++) {
                    values[i] = Double.parseDouble(rawValues[i]);
                }

                output.add(values);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        double[][] array = new double[output.size()][];
        for(int i=0; i < output.size(); i++) {
            array[i] = output.get(i);
        }

        return array;
    }

    public static void main(String[] args) {
        for (double[] d : dataFrom("data/Galton.csv")) {
            System.out.println(Arrays.toString(d));
        }
    }
}
