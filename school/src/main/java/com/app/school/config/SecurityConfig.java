package com.app.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/auth/**").permitAll()  // Allow all requests to /auth/** endpoints
                        .requestMatchers(HttpMethod.POST, "/api/**").authenticated()    // Allow all requests to /api/** endpoints
                        .anyRequest().permitAll()               // Require authentication for all other requests
                )
                .httpBasic(Customizer.withDefaults()) // Enables Basic Authentication
                .csrf(csrf -> csrf.disable());         // Disables CSRF protection for simplicity

        return http.build();
    }

    // Define the user details service
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("yourUsername")
                .password(passwordEncoder().encode("yourPassword"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    // Define the password encoder (BCrypt for better security)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}