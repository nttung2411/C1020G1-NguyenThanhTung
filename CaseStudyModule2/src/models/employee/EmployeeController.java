package models.employee;

import common.FileUtils;
import controllers.MainController;
import models.employee.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeController {
    public static void showEmployee() throws IOException {
        Map<String, Employee> listEmployee = new TreeMap<>();
        List<String> fileEmployee = FileUtils.readFile("src/data/Employee.csv");

        for (int index = 0 ; index < fileEmployee.size() ; index++){
            String[] array = fileEmployee.get(index).split(",");
            Employee employee = new Employee(array[1],Integer.parseInt(array[2]),array[3]);
            listEmployee.put(array[0],employee);
        }
        for(Map.Entry<String,Employee> entry : listEmployee.entrySet()){
            System.out.println("Mã số: " + entry.getKey() + " , " + entry.getValue());
        }
        MainController.displayMainMenu();
    }
}
