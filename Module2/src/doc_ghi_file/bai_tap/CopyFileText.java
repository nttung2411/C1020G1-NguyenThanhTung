package doc_ghi_file.bai_tap;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tập tin nguồn");
        String sourceFile = scanner.nextLine();
        System.out.println("Nhập tập tin đích");
        String targetFile = scanner.nextLine();

        try{
            FileReader fileReader = new FileReader(sourceFile);

            File file = new File(targetFile);
            if(!file.createNewFile()){
                System.err.println("File đã được tạo từ trước");
                return;
            }

            FileWriter fileWriter = new FileWriter(targetFile);

            int i = 0;
            while((i = fileReader.read()) != -1){
                fileWriter.write(i);
            }

            fileWriter.close();

        } catch (Exception e) {
            System.err.println("Không tìm thấy file nguồn");
        }

    }
}
