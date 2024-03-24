package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.ProductImage;

import java.util.List;

public interface ProductImageService {

    ProductImage createProductImage(ProductImage productImage);
    void deleteProductImage(Long id);
}
