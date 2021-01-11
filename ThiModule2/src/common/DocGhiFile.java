package common;

import mobilePhone.DienThoai;
import mobilePhone.DienThoaiChinhHang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
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

    public static void writeUpdate(List<String> mobileList) throws IOException {
        File file = new File("src/data/DienThoai.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for(String mobile : mobileList){
            bufferedWriter.write(mobile);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
