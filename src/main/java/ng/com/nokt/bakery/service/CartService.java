package ng.com.nokt.bakery.service;

import ng.com.nokt.bakery.entity.Cart;

public interface CartService {

    Cart createCart(Cart cart);
    Cart updateCart(Cart cart, Long id);
}
