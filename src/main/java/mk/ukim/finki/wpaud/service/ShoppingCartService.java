package mk.ukim.finki.wpaud.service;

import mk.ukim.finki.wpaud.model.Product;
import mk.ukim.finki.wpaud.model.ShoppingCart;
import mk.ukim.finki.wpaud.model.enumerations.ShoppingCartStatus;

import java.util.List;

public interface ShoppingCartService {
    List<Product> listAllProductsInShoppingCart(Long id);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);
}
