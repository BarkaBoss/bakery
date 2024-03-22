package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.Cart;
import ng.com.nokt.bakery.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart, Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);

        if(optionalCart.isPresent()){
            Cart updatedCart = new Cart();

            updatedCart.setId(cart.getId());
            updatedCart.setProducts(cart.getProducts());


            return cartRepository.save(updatedCart);
        }else {
            throw new RuntimeException("Cart does not exist");
        }
    }
}
