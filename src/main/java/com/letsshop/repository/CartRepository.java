//package com.letsshop.repository;
//
//import com.letsshop.entities.Cart;
//import com.letsshop.entities.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface CartRepository extends JpaRepository<Cart, Long> {
//    Optional<Cart> findByUser(User user);
//}