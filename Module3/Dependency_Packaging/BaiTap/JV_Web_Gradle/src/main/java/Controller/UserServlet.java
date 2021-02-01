package Controller;

import Model.Bean.User;
import Model.Service.UserService;
import Model.Service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet",urlPatterns = "")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");

        if (action == null){
            action = "";
        }

        switch (action){
            case "update":
                updateUser(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");

        if (action == null){
            action = "";
        }

        switch (action){
            case "delete":
                deleteUser(request,response);
                break;
            case "update":
                showUpdateUser(request,response);
                break;
            default:
                selectList(request,response);
                break;
        }
    }

    private void selectList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", userService.selectAllUser());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void showUpdateUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUserByID(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    private void updateUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        try {
            userService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        selectList(request,response);
    }

    private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        selectList(request,response);
    }
}
