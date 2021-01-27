package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                int id = (int)(Math.random() * 10000);

                Customer customer = new Customer(id,name,email,address);
                this.customerService.save(customer);
                request.setAttribute("message","New customer ward created");
                request.getRequestDispatcher("create.jsp").forward(request,response);
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                String nameEdit = request.getParameter("name");
                String emailEdit = request.getParameter("email");
                String addressEdit = request.getParameter("address");
                Customer customerEdit = this.customerService.findById(idEdit);
                customerEdit.setName(nameEdit);
                customerEdit.setEmail(emailEdit);
                customerEdit.setAddress(addressEdit);
                this.customerService.update(idEdit,customerEdit);
                request.setAttribute("customer",customerEdit);
                request.setAttribute("message", "Customer information was updated");
                request.getRequestDispatcher("edit.jsp").forward(request,response);
                break;
            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                Customer customerDelete = this.customerService.findById(idDelete);
                this.customerService.remove(idDelete);
                response.sendRedirect("/customers");
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request,response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = this.customerService.findById(id);
                request.setAttribute("customer",customer);
                request.getRequestDispatcher("edit.jsp").forward(request,response);
                break;
            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                Customer customerDelete = this.customerService.findById(idDelete);
                request.setAttribute("customer",customerDelete);
                request.getRequestDispatcher("delete.jsp").forward(request,response);
                break;
            case "view":
                break;
            default:
                request.setAttribute("customerListFromServlet",customerService.findAll());
                request.getRequestDispatcher("list_customers.jsp").forward(request,response);
                break;
        }
    }
}
