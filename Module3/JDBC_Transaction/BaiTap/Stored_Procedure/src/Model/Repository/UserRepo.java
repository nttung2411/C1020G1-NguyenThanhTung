package Model.Repository;

import Model.Bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepo {
    List<User> selectAllUser();

    void updateUser(User user) throws SQLException;

    void deleteUser(Integer id);

    User selectUserByID(Integer id);
}
