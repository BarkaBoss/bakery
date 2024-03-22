package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.Product;
import ng.com.nokt.bakery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product updatedProduct = new Product();
            updatedProduct.setId(product.getId());
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setQuantity(product.getQuantity());
            updatedProduct.setImages(product.getImages());

            productRepository.save(updatedProduct);
            return updatedProduct;
        }else {
            throw new RuntimeException("Product does not exist");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository
                .deleteById(id);
    }
}
