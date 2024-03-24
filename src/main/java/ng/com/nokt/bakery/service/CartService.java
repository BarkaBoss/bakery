package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.Cart;
import ng.com.nokt.bakery.entity.Product;

public interface CartService {

    Cart createCart(Cart cart);
    Cart updateCart(Cart cart, Long id);
    Cart addProductToCart(Product product, Cart cart);
}
