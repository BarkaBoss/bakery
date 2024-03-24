package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.dto.CustomerDto;
import ng.com.nokt.bakery.dto.LoginDto;
import ng.com.nokt.bakery.entity.Cart;
import ng.com.nokt.bakery.entity.Customer;
import ng.com.nokt.bakery.entity.Product;
import ng.com.nokt.bakery.utils.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    String createCustomer(CustomerDto customerDto);
    LoginResponse loginCustomer(LoginDto loginDto);
    Cart addItemToCart(Product product, Customer customer);

}
