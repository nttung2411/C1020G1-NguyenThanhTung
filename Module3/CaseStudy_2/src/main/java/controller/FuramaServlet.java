package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.service.FuramaService;
import model.service.FuramaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuramaServlet",urlPatterns = "")
public class FuramaServlet extends HttpServlet {

    FuramaService furamaService = new FuramaServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }

        switch (action) {
            case "addCustomer":
                addCustomer(request, response);
                break;
            case "addEmployee":
                addEmployee(request,response);
                break;
            case "editCustomer":
                updateCustomer(request,response);
                break;
            case "editEmployee":
                updateEmployee(request,response);
                break;
            case "addService":
                break;
            case "addContract":
                break;
            case "showContractDetail":
                break;
            case "addContractDetail":
                break;
            default:
                showHome(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }

        switch (action){
            case "addCustomer":
                showAddCustomer(request,response);
                break;
            case "showListCustomer":
                showListCustomer(request,response);
                break;
            case "searchCustomer":
                searchCustomer(request,response);
                break;
            case "addEmployee":
                showAddEmployee(request,response);
                break;
            case "showListEmployee":
                showListEmployee(request,response);
                break;
            case "searchEmployee":
                searchEmployee(request,response);
                break;
            case "editCustomer":
                showUpdateCustomer(request,response);
                break;
            case "editEmployee":
                showUpdateEmployee(request,response);
            case "deleteCustomer":
                deleteCustomer(request,response);
                break;
            case "deleteEmployee":
                deleteEmployee(request,response);
            case "showListService":
                break;
            case "addContract":
                break;
            case "showListContract":
                break;
            case "showContractDetail":
                break;
            case "addContractDetail":
                break;
            default:
                showHome(request,response);
                break;
        }
    }

    private void showHome(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    private void showAddCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addCustomer.jsp").forward(request,response);
    }

    private void showAddEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addEmployee.jsp").forward(request,response);
    }

    private void addCustomer(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int type = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");


        Customer customer = new Customer(id,type,name,dateOfBirth,gender,cmnd,phone,email,address);
        furamaService.addCustomer(customer);
        showHome(request,response);
    }

    private void addEmployee(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int position = Integer.parseInt(request.getParameter("position"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Double salary = Double.parseDouble(request.getParameter("salary"));


        Employee employee = new Employee(id,name,dateOfBirth,gender,cmnd,salary,phone,email,address,position);
        furamaService.addEmployee(employee);
        showHome(request,response);
    }

    private void showListCustomer(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomer",furamaService.FindAllCustomer());
        request.getRequestDispatcher("showListCustomer.jsp").forward(request,response);
    }

    private void showListEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listEmployee",furamaService.findAllEmployee());
        request.getRequestDispatcher("showListEmployee.jsp").forward(request,response);
    }

    private void searchCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("listCustomer",furamaService.searchCustomer(name));
        request.getRequestDispatcher("searchCustomer.jsp").forward(request,response);
    }

    private void searchEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("listEmployee",furamaService.searchEmployee(name));
        request.getRequestDispatcher("searchEmployee.jsp").forward(request,response);
    }

    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Customer customer = furamaService.selectCustomerById(id);

        request.setAttribute("customer",customer);
        request.getRequestDispatcher("editCustomer.jsp").forward(request,response);
    }

    private void showUpdateEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = furamaService.selectEmployeeById(id);

        request.setAttribute("employee",employee);
        request.getRequestDispatcher("editEmployee.jsp").forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int type = Integer.parseInt(request.getParameter("type"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id,type,name,dateOfBirth,gender,id_card,phone,email,address);
        furamaService.updateCustomer(customer);
        showListCustomer(request,response);
    }

    private void updateEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int position = Integer.parseInt(request.getParameter("position"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String id_card = request.getParameter("CMND");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee(id,name,dateOfBirth,gender,id_card,salary,phone,email,address,position);
        furamaService.updateEmployee(employee);
        showListEmployee(request,response);
    }



    public void deleteCustomer(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String access = request.getParameter("value");
        int id = Integer.parseInt(request.getParameter("id"));

        furamaService.deleteCustomer(id,access);
        showListCustomer(request,response);
    }

    public void deleteEmployee(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String access = request.getParameter("value");
        int id = Integer.parseInt(request.getParameter("id"));

        furamaService.deleteEmployee(id,access);
        showListEmployee(request,response);
    }

}
