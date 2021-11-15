import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Plik {

    public static void main(String[] args) throws IOException {

            String path = "C:\\Users\\gabwi\\IdeaProjects\\Lab3\\sales_data_sample.csv";
            String line ;
            String [] values = new String[0];
            LinkedList<String> sales = new LinkedList<>();
            int iterator=0;
            try{
                BufferedReader br = new BufferedReader(new FileReader(path));
                while(((line = br.readLine())) != null){
                    if(iterator == 0){
                        iterator++;
                        continue;
                    }
                    values = line.split(",");
                    sales.add(values[4]);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        //displays 5 highest sales
         sales.stream()
                 .map(l -> Double.parseDouble(l))
                 .sorted(Comparator.reverseOrder())
                 .limit(5)
                 .forEach(System.out::println);


    }
}
