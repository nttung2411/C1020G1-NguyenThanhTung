import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomersServlet",urlPatterns = {"","/index"})
public class CustomersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Nguyễn Tùng","24/11/1995","Đà Nẵng",
                "https://cdn4.vectorstock.com/i/thumb-large/72/38/male-user-round-icon-isolated-man-anonymous-vector-22977238.jpg"));

        customerList.add(new Customer("Lê Tùng","25/11/1995","Quảng Nam",
                "https://www.tubefilter.com/wp-content/uploads/2019/11/dobrik-people.jpg"));

        customerList.add(new Customer("Trung Tùng","26/11/1995","Mỹ Tho",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZW7p2xODj_yKM0Wynx3Rv86l03lH-nHgUiw&usqp=CAU"));

        customerList.add(new Customer("Thanh Tùng","27/11/1995","Huế",
                "https://0.gravatar.com/avatar/3a06f8e820f297e4e5bacb01124c693c?s=228&d=https%3A%2F%2F0.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D228&r=G"));

        customerList.add(new Customer("Lý Tùng","24/11/1995","Quảng Trị",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSu0BzRWeDfBA7kjWkFJP1QgS2Km9V0E_7b-g&usqp=CAU"));

        request.setAttribute("customerListServlet",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
