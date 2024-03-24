package ng.com.nokt.bakery.repository;

import ng.com.nokt.bakery.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
