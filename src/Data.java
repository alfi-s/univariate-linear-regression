import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<List<Double>> dataFrom(String fileName) {
        List<List<Double>> output = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = reader.readLine()) != null) {
                String[] rawValues = line.split(",");
//                double[] values = new double[rawValues.length];
                for(int i = 0; i < rawValues.length; i++) {
                    if(i >= output.size()) output.add(new ArrayList<>());
                    output.get(i).add(Double.parseDouble(rawValues[i]));
//                    values[i] = Double.parseDouble(rawValues[i]);
                }

//                output.add(values);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }
}
