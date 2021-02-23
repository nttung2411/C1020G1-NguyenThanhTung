package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "")
public class Servlet extends HttpServlet {

    ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if(action.equals("addProduct")){
            addProduct(request,response);
        }else if(action.equals("listProduct")){
            showLisProductByDate(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "listProduct":
                showListProduct(request, response);
                break;
            case "addProduct":
                showAddProduct(request, response);
                break;
            default:
                showHome(request, response);
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProduct", productService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showAddProduct(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }

    private void addProduct(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Double discount = Double.parseDouble(request.getParameter("discount"));
        Integer stock = Integer.parseInt(request.getParameter("stock"));

        Product product = new Product(name,price,discount,stock);
        String msg = productService.addProduct(product);

        request.setAttribute("msgDisplay",msg);

        if(msg.equals("OK")){
            showListProduct(request,response);
        } else {
            showAddProduct(request,response);
        }
    }

    private void showLisProductByDate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");

        request.setAttribute("listProduct",productService.findByDate(start,end));
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
