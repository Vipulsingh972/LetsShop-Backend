//package com.letsshop.controller;
//
//
//import com.letsshop.entities.Cart;
//import com.letsshop.entities.CartItem;
//import com.letsshop.services.interfac.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/cart")
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    // Get the cart for a user
//    @GetMapping("/{userId}")
//    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
//        Cart cart = cartService.getCartByUser(userId);
//        if (cart != null) {
//            return ResponseEntity.ok(cart);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Add a product to the cart
//    @PostMapping("/add/{userId}/{productId}")
//    public ResponseEntity<CartItem> addToCart(
//            @PathVariable Long userId,
//            @PathVariable Long productId,
//            @RequestParam Integer quantity) {
//        CartItem cartItem = cartService.addToCart(userId, productId, quantity);
//        if (cartItem != null) {
//            return ResponseEntity.ok(cartItem);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    // Remove a product from the cart
//    @DeleteMapping("/remove/{cartItemId}")
//    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartItemId) {
//        cartService.removeFromCart(cartItemId);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Get the total amount of the cart
//    @GetMapping("/total/{cartId}")
//    public ResponseEntity<Double> calculateTotal(@PathVariable Long cartId) {
//        Double total = cartService.calculateTotal(cartId);
//        return ResponseEntity.ok(total);
//    }
//}
