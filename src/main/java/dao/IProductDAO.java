package dao;

import models.Product;

public interface IProductDAO {
    
    void saveProduct(Product product);

    Product getProduct(String name);

    Integer getProductAmount(String name);

    void updateProduct(String name, Integer amount);

    void deleteProduct(Integer id);

    void deleteProduct(String name);

}
