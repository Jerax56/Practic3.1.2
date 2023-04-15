package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void saveUsers(User user);

    User getUser(int ID);

    void updateUser(User user);

    void deleteUser(int ID);
}
