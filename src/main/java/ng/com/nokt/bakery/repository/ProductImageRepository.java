package ng.com.nokt.bakery.repository;

import ng.com.nokt.bakery.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
