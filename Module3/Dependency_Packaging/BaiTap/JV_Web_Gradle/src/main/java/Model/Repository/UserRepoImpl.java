package Model.Repository;

import Model.Bean.User;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.baseRepo.getConnection().prepareCall("call select_all_user()");

            ResultSet resultSet = callableStatement.executeQuery();

            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void updateUser(User user) {
        try {
            CallableStatement callableStatement =
                    this.baseRepo.getConnection().prepareCall("call update_user_by_id(?,?,?,?)");
                    callableStatement.setString(1,String.valueOf(user.getId()));
                    callableStatement.setString(2,user.getName());
                    callableStatement.setString(3,user.getEmail());
                    callableStatement.setString(4,user.getCountry());
                    callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            CallableStatement callableStatement =
                    this.baseRepo.getConnection().prepareCall("call delete_user(?)");
                    callableStatement.setString(1,String.valueOf(id));
                    callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUserByID(Integer id) {

        User user = null;
        try {
            user = new User();
            CallableStatement callableStatement =
                    this.baseRepo.getConnection().prepareCall("call select_user_by_id(?)");
            callableStatement.setString(1,String.valueOf(id));

            ResultSet resultSet = callableStatement.executeQuery();
            resultSet.next();

                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
