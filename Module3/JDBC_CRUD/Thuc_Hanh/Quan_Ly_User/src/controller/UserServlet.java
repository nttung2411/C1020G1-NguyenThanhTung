package controller;

import model.bean.User;
import model.repository.UserRepository;
import model.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "")
public class UserServlet extends HttpServlet {

    private UserRepository userRepository;

    public void init(){
        userRepository = new UserRepositoryImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                insertUser(request,response);
                break;
            case "edit":
                updateUser(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "countryUser":
                showUser(request,response);
                break;
            case "Sort":
                sortByName(request,response);
                break;
            default:
                listUser(request,response);
                break;
        }
    }

    private void listUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userRepository.selectAllUsers();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("test.jsp").forward(request,response);
    }

    private void insertUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name,email,country);
        try {
            userRepository.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listUser(request,response);
    }

    private void updateUser(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        try {
            userRepository.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listUser(request,response);
    }

    private void showCreate(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }

    private void showEdit(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userRepository.selectUser(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void deleteUser(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            userRepository.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        listUser(request,response);
    }

    private void showUser(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");

        List<User> userList = userRepository.selectAllUsers();

        List<User> countryListUser = new ArrayList<>();

        for (User user : userList){
            if (user.getCountry().equals(country)){
                countryListUser.add(user);
            }
        }

        request.setAttribute("listUser",countryListUser);
        request.getRequestDispatcher("listSearch.jsp").forward(request,response);
    }

    private void sortByName(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userRepository.selectAllUsers();

        Collections.sort(userList);

        request.setAttribute("listUser",userList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
