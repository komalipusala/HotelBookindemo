package com.example.HotelBooking_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF (for testing purposes)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // Allow all requests without authentication
            )
            .formLogin(form -> form.disable())  // Disable default login form
            .httpBasic(httpBasic -> httpBasic.disable());  // Disable Basic Auth

        return http.build();
    }
}
