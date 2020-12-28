package common;

import models.Employee;
import models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void writeFile(String pathFile,Object line){
        try{
            FileWriter fileWriter = new FileWriter(pathFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line + "\n");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String pathFile) throws IOException {
        List<String> listLine = new ArrayList<>();

        FileReader fileReader = new FileReader(pathFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            listLine.add(line);
        }
        return listLine;
    }

    public static void writeFileBooking(String pathFile , String line){
        try{
            FileWriter fileWriter = new FileWriter(pathFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line + "\n");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readFileEmployee() throws IOException, ClassNotFoundException {
        List<Employee> listLine = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("src/data/Employee.csv");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        listLine.add((Employee) objectInputStream.readObject());
        return listLine;
    }
}
