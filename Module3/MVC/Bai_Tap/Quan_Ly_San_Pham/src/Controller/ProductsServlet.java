package Controller;

import Model.Product;
import Service.ProductService;
import Service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsServlet",urlPatterns = "")
public class ProductsServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
               showDelete(request,response);
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productsListFromServlet",productService.findAll());
        request.getRequestDispatcher("list_products.jsp").forward(request,response);
    }

    private void createProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        Double price = Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("image");
        Product product = new Product(name,manufacturer,price,img);
        productService.save(product);
        listProduct(request,response);
    }

    private void showDelete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Product product = this.productService.search(name);
        request.setAttribute("product",product);
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        productService.remove(name);
        listProduct(request,response);
    }

    private void showEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Product product = this.productService.search(name);
        request.setAttribute("product",product);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void editProduct(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String manufacturer = request.getParameter("manufacturer");
        String image = request.getParameter("image");
        Product product = this.productService.search(name);

        product.setPrice(price);
        product.setManufacturer(manufacturer);
        product.setImage(image);

        this.productService.update(name,product);

        listProduct(request,response);


    }
}
