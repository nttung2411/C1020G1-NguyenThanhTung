import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double number1 = Double.parseDouble(request.getParameter("firstNumber"));
        double number2 = Double.parseDouble(request.getParameter("secondNumber"));
        String operator = request.getParameter("operator");

        String result = Calculator.calculator(number1,number2,operator);

        request.setAttribute("firstNumber",number1);
        request.setAttribute("secondNumber",number2);
        request.setAttribute("operator",operator);
        request.setAttribute("result",result);
        request.getRequestDispatcher("show_result.jsp").forward(request,response);
    }
}
