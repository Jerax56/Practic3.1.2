package web.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUsers(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User getUser(int ID) {
        return entityManager.find(User.class, ID);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(int ID) {
        entityManager.remove(getUser(ID));
        entityManager.flush();
    }
}
