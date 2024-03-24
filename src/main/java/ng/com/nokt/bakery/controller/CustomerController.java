package ng.com.nokt.bakery.controller;

import ng.com.nokt.bakery.dto.CustomerDto;
import ng.com.nokt.bakery.dto.LoginDto;
import ng.com.nokt.bakery.service.CustomerService;
import ng.com.nokt.bakery.utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public String createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = customerService.loginCustomer(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}
