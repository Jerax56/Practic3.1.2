package web.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repositories.UserDao;

import java.util.List;

@Component
public class UserServiceImp implements UserService {

    private UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    @Override
    public void saveUsers(User user) {
        userDao.saveUsers(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(int ID) {
        return userDao.getUser(ID);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int ID) {
        userDao.deleteUser(ID);
    }
}
