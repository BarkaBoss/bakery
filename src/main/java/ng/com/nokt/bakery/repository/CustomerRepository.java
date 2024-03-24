package ng.com.nokt.bakery.repository;

import ng.com.nokt.bakery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
