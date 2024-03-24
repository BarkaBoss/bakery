package ng.com.nokt.bakery.repository;

import ng.com.nokt.bakery.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
