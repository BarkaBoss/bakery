package ng.com.nokt.bakery.repository;

import ng.com.nokt.bakery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByEmailAndPassword(String email, String password);
    Customer findCustomerByEmail(String email);
}
