package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.dto.CustomerDto;
import ng.com.nokt.bakery.dto.LoginDto;
import ng.com.nokt.bakery.entity.Cart;
import ng.com.nokt.bakery.entity.Customer;
import ng.com.nokt.bakery.entity.Product;
import ng.com.nokt.bakery.repository.CartRepository;
import ng.com.nokt.bakery.repository.CustomerRepository;
import ng.com.nokt.bakery.utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    final private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    final private CartRepository cartRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public String createCustomer(CustomerDto customerDto) {
        if (customerRepository.findCustomerByEmail(customerDto.getEmail()) == null){
            Customer customer = new Customer(
                    customerDto.getId(),
                    customerDto.getName(),
                    customerDto.getEmail(),
                    this.passwordEncoder.encode(customerDto.getPassword()),
                    customerDto.getPhoneNumber(),
                    customerDto.getAddress(),
                    new Cart()
            );
            customerRepository.save(customer);
            return customer.getEmail();
        }else {
            throw new RuntimeException("User already Exists");
        }

    }

    @Override
    public LoginResponse loginCustomer(LoginDto loginDto) {
        String message = "";

        Customer customer = customerRepository.findCustomerByEmail(loginDto.getEmail());
        if (customer != null){
            String password = loginDto.getPassword();
            String encodedPassword = customer.getPassword();
            boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);

            if (isPasswordMatch){
                Optional<Customer> customerOptional = customerRepository.findCustomerByEmailAndPassword(
                        loginDto.getEmail(),
                        encodedPassword);

                if (customerOptional.isPresent()){
                    return new LoginResponse("Login Success", true);
                }else {
                    return new LoginResponse("Login Failed", false);
                }
            }else {
                return new LoginResponse("Password Not a Match", false);
            }
        }else {
            return new LoginResponse("Email does not exist", false);
        }
    }

    @Override
    public Cart addItemToCart(Product product, Customer customer) {
        Cart customerCart = customer.getCart();
        customerCart.getProducts().add(product);
        cartRepository.save(customerCart);
        return customer.getCart();
    }
}
