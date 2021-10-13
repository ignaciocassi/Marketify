package dao;

import java.util.List;

import models.Product;
import models.User;

public class UserService {

    private static UserDAOImpl userDAOImpl;

    public UserService() {
        userDAOImpl = new UserDAOImpl();
    }

    public void save(User user) {
        userDAOImpl.openCurrentSessionwithTransaction();
        userDAOImpl.saveUser(user);
        userDAOImpl.closeCurrentSessionwithTransaction();
    }

    public void update(User user) {
        userDAOImpl.openCurrentSessionwithTransaction();
        userDAOImpl.saveUser(user);
        userDAOImpl.closeCurrentSessionwithTransaction();
    }

    public User get(Integer id) {
        userDAOImpl.openCurrentSession();
        User user = userDAOImpl.getUser(id);
        userDAOImpl.closeCurrentSession();
        return user;
    }

    public List<Product> getAllProducts() {
        List<Product> products = userDAOImpl.getAllUsersProduct();
        return products;
    }

    public void delete(Integer id) {
        userDAOImpl.openCurrentSessionwithTransaction();
        userDAOImpl.deleteUser(userDAOImpl.getUser(id));
        userDAOImpl.closeCurrentSessionwithTransaction();
    }
    
}
