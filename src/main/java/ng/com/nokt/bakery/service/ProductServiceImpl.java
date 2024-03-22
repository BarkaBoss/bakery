package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.ProductImage;
import ng.com.nokt.bakery.repository.ProductImageRepository;
import ng.com.nokt.bakery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;


    @Autowired
    public ProductServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }


    @Override
    public ProductImage createProductImage(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public void deleteProductImage(Long id) {
        productImageRepository.deleteById(id);
    }
}
