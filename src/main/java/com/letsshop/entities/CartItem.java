//package com.letsshop.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class CartItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;  // CartItem belongs to one Cart
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;  // CartItem is for one Product
//
//    private Integer quantity;  // Quantity of the product in the cart
//    private Double price;
//}
