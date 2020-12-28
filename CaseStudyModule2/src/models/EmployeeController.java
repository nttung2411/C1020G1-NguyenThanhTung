package models;

import common.FileUtils;
import controllers.MainController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeController {
    public static void showEmployee() throws IOException, ClassNotFoundException {
        Map<String,Employee> listEmployee = new TreeMap<>();
        List<String> fileEmployee = FileUtils.readFile("src/data/Employee.csv");

        int count = 1;
        for (int index = 0 ; index < fileEmployee.size() ; index++){
            String[] array = fileEmployee.get(index).split(",");
            Employee employee = new Employee(array[0],Integer.parseInt(array[1]),array[2]);

            if(count < 10){
                listEmployee.put("00" + count,employee);
                count++;
            }else {
                listEmployee.put("0" + count,employee);
            }
        }
        for(Map.Entry<String,Employee> entry : listEmployee.entrySet()){
            System.out.println("Mã số: " + entry.getKey() + " , " + entry.getValue());
        }
        MainController.displayMainMenu();
    }
}
