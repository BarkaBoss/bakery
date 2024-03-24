package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.Cart;
import ng.com.nokt.bakery.entity.Customer;
import ng.com.nokt.bakery.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Cart addItemToCart(Product product, Customer customer);

}
