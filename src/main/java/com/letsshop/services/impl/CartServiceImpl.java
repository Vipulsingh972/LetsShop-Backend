//package com.letsshop.services.impl;
//
//import com.letsshop.dto.CartDTO;
//import com.letsshop.dto.CartItemDTO;
//import com.letsshop.entities.Cart;
//import com.letsshop.entities.CartItem;
//import com.letsshop.entities.Product;
//import com.letsshop.repository.CartItemRepository;
//import com.letsshop.repository.CartRepository;
//import com.letsshop.repository.ProductRepository;
//import com.letsshop.services.interfac.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CartServiceImpl implements CartService {
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CartItemRepository cartItemRepository;
//
//    @Override
//    public CartDTO getCartByUser(Long userId) {
//        // Get cart for user
//        Cart cart = cartRepository.findByUser(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
//        // Convert Cart to CartDTO
//        return convertToDTO(cart);
//    }
//
//    @Override
//    public CartDTO addToCart(Long userId, CartItemDTO cartItemDTO) {
//        Cart cart = cartRepository.findByUser(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
//
//        Product product = productRepository.findById(cartItemDTO.getProductId())
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//        CartItem cartItem = new CartItem(cart, product, cartItemDTO.getQuantity());
//        cartItemRepository.save(cartItem);
//        cart.getCartItems().add(cartItem);
//        cartRepository.save(cart);
//
//        return convertToDTO(cart);
//    }
//
//    @Override
//    public void removeFromCart(Long cartItemId) {
//        cartItemRepository.deleteById(cartItemId);
//    }
//
//    @Override
//    public Double calculateTotal(Long cartId) {
//        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
//        return cart.getCartItems().stream()
//                .mapToDouble(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
//                .sum();
//    }
//
//    private CartDTO convertToDTO(Cart cart) {
//        // Convert Cart to CartDTO
//        CartDTO cartDTO = new CartDTO();
//        cartDTO.setId(cart.getId());
//        cartDTO.setUserId(cart.getUser().getId());
//        cartDTO.setTotalAmount(cart.getTotalAmount());
//        // Add cartItems to cartDTO
//        // Implement similar for CartItemDTO
//        return cartDTO;
//    }
//}
