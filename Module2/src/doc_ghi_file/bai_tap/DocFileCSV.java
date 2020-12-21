package doc_ghi_file.bai_tap;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocFileCSV {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("FileTxt/file.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while((line = bufferedReader.readLine()) != null){
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String element : listLine){
            System.out.println(element);
        }
    }
}
