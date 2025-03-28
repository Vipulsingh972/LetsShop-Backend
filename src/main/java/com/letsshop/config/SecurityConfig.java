//package com.letsshop.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        // CSRF handling for Spring Security 6
//        httpSecurity
//                .csrf(csrf -> csrf
//                        .disable())  // Disable CSRF for stateless applications like APIs
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/api/users/signup", "/api/users/login")  // Public endpoints
//                        .permitAll()  // Allow access to sign-up and login endpoints without authentication
//                        .requestMatchers("/api/contact/submit")  // Make sure /api/contact/submit requires authentication
//                        .authenticated()  // Only authenticated users can access /api/contact/submit
//                        .anyRequest().authenticated())  // All other requests require authentication
//                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Stateless session management
//                .formLogin(withDefaults());  // Enable form login with default settings
//
//        return httpSecurity.build();  // Return the security configuration
//    }
//}


package com.letsshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // CSRF handling for Spring Security 6
        httpSecurity
                .csrf(csrf -> csrf
                        .disable())  // Disable CSRF for stateless applications like APIs
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/users/signup", "/api/users/login", "/api/contact/submit")  // Public endpoints including contact form
                        .permitAll()  // Allow access to signup, login, and contact form without authentication
                        .anyRequest().authenticated())  // All other requests require authentication
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Stateless session management
                .formLogin(withDefaults());  // Enable form login with default settings

        return httpSecurity.build();  // Return the security configuration
    }
}
