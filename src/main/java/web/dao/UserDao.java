package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void deleteUserById(int id);

    void editUserById(User user);

}
