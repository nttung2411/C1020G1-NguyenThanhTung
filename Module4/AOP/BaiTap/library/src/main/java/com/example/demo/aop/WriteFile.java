package com.example.demo.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.io.*;

@Aspect
public class WriteFile {

    public static String nameOfBook;

    @AfterReturning(pointcut = "execution(public * com.example.demo.controllers.BooksController.createBook(*))")
    public void afterCreateBook() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\C1020G1_NguyenThanhTung\\Module4\\AOP\\BaiTap\\library\\src\\main\\resources\\static\\history.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Đã thêm sách mới: " + nameOfBook);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    @AfterReturning(pointcut = "execution(public * com.example.demo.controllers.RenterController.saveRentBook(*))")
    public void afterRentBook() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\C1020G1_NguyenThanhTung\\Module4\\AOP\\BaiTap\\library\\src\\main\\resources\\static\\history.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Sách vừa được mượn: " + nameOfBook);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    @AfterReturning(pointcut = "execution(public * com.example.demo.controllers.RenterController.refundBook(*))")
    public void afterRefundBook() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\C1020G1_NguyenThanhTung\\Module4\\AOP\\BaiTap\\library\\src\\main\\resources\\static\\history.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Sách vừa được trả: " + nameOfBook);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    @AfterReturning(pointcut = "execution(public * com.example.demo.controllers.BooksController.showPage(*,*))")
    public void afterViewLibrary() throws IOException {
        FileReader fileReader = new FileReader("D:\\C1020G1_NguyenThanhTung\\Module4\\AOP\\BaiTap\\library\\src\\main\\resources\\static\\viewhistory.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String viewHistory = bufferedReader.readLine();
        Integer quantityView = Integer.parseInt(viewHistory.split(" ")[5]) + 1;


        FileWriter fileWriter = new FileWriter("D:\\C1020G1_NguyenThanhTung\\Module4\\AOP\\BaiTap\\library\\src\\main\\resources\\static\\viewhistory.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Số người đã truy cập: " + quantityView);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
