import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<Iris> getDataset(String path){
        ArrayList<Iris> dataset=new ArrayList<Iris>();
            try(BufferedReader br = new BufferedReader(new FileReader(path))) {
                //StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    String[] tokens = line.split(",");
                    dataset.add(new Iris(Double.parseDouble(tokens[0]),
                            Double.parseDouble(tokens[1]),
                            Double.parseDouble(tokens[2]),
                            Double.parseDouble(tokens[3]),
                            tokens[4]));
                    //sb.append(line);
                    //sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                //String everything = sb.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return dataset;
    }

}
