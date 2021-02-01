package Model.Service;

import Model.Bean.User;
import Model.Repository.UserRepo;
import Model.Repository.UserRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepo userRepo = new UserRepoImpl();

    @Override
    public List<User> selectAllUser() {
        return userRepo.selectAllUser();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userRepo.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteUser(id);
    }

    @Override
    public User selectUserByID(Integer id) {
        return userRepo.selectUserByID(id);
    }
}
