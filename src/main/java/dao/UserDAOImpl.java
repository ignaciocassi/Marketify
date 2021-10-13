package dao;

import java.util.List;
import models.Product;
import models.User;

public class UserDAOImpl extends CommonDAO implements IUserDAO {

    @Override
    public void saveUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public User getUser(Integer id) {
        User user = (User) super.getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public Boolean checkEmailRegistered(String email) {
        Boolean emailRegistered = false; //query;
        return emailRegistered;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllUsersProduct() {
        List<Product> products = (List<Product>) super.getCurrentSession().createQuery("from product where user_id = 1").list();
        return products;
    }

    @Override
    public Boolean checkPasswd(String passwd) {
        Boolean passwdMatch = false; //query
        return passwdMatch;
    }

    @Override
    public void updateUser(User user) {
        super.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        getCurrentSession().delete(user);
    }
    
}
