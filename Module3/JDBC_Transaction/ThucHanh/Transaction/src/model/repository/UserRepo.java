package model.repository;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepo {
    public User getUserById(int id);

    public void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    public void addUserTransaction(User user, int[] permision);
}
