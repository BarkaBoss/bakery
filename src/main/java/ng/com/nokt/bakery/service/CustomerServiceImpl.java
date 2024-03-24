package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.Cart;
import ng.com.nokt.bakery.entity.Customer;
import ng.com.nokt.bakery.entity.Product;
import ng.com.nokt.bakery.repository.CartRepository;
import ng.com.nokt.bakery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    final private CustomerRepository customerRepository;
    final private CartRepository cartRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public Cart addItemToCart(Product product, Customer customer) {
        Cart customerCart = customer.getCart();
        customerCart.getProducts().add(product);
        cartRepository.save(customerCart);
        return customer.getCart();
    }
}
