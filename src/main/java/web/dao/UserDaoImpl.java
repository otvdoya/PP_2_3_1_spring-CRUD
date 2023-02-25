package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("from User").getResultList();
        return users;
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void editUserById(User user) {
        User updatingUser = getUserById(user.getId());
        updatingUser.setName(user.getName());
        updatingUser.setSurname(user.getSurname());
        updatingUser.setAge(user.getAge());
    }
}
