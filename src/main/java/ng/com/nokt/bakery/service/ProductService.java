package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Product product, Long id);
    void  deleteProduct(Long id);
}
