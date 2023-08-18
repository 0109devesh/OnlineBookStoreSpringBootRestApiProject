package com.example.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import com.example.bookstore.security.JwtAuthenticationEntryPoint;
import com.example.bookstore.security.JwtAuthenticationFilter;



@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;
    
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private CorsFilter corsFilter;

    
      
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/home/**").authenticated()
                        .requestMatchers("/books/register-book").authenticated()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/create-user").permitAll() // Allow access without authentication
                        .requestMatchers("/books/books-list").permitAll() 
                        .requestMatchers("/books/book/{bookId}").permitAll() 
                        .anyRequest().authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    
   

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
    	
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setUserDetailsService(userDetailsService);
    	provider.setPasswordEncoder(passwordEncoder);
    	
    	return provider;
    }
    

   
    
    
    
    
}