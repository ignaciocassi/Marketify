package dao;

import java.util.List;
import models.Product;
import models.User;

public interface IUserDAO {

    void saveUser(User user);

    User getUser(Integer id);

    Boolean checkEmailRegistered(String email);

    List<Product> getAllUsersProduct();

    Boolean checkPasswd(String passwd);

    void updateUser(User user);

    void deleteUser(User user);
    
}
