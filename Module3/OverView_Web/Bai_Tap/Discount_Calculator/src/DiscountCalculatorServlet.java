import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountCalculatorServlet",urlPatterns = "/calculator")
public class DiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String nameProduct = request.getParameter("nameProduct");
        Float priceProduct = Float.parseFloat(request.getParameter("priceProduct"));
        Float discountProduct = Float.parseFloat(request.getParameter("discountProduct"));

        Float discountAmount = priceProduct*discountProduct*0.01f;
        Float discountPrice = priceProduct - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Tên sản phẩm: " + nameProduct);
        writer.println("Giá sản phẩm: " + priceProduct);
        writer.println("Giảm giá: " + discountProduct + "%");
        writer.println("Giá được giảm: " + discountAmount);
        writer.println("Giá sản phẩm sau khi giảm: " + discountPrice);
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
