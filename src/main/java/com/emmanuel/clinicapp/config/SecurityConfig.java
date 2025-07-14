package com.emmanuel.clinicapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.emmanuel.clinicapp.security.JwtFilter;

@Configuration
public class SecurityConfig {
    @Bean
      public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // csrf(Cross site request forgery) desactiva protección contra CSRF (necesaria para APIs)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/api/auth/**").permitAll() // permite login y autentication sin token
                                 .anyRequest().authenticated()
                 )

                 //jwtfilter es un filtro que valida token antes que llegue a los controladores
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    
    }

    //interfaz de spring security para cargar los datos de un usuario por su nombre
    
    @Bean
    public UserDetailsService UserDetailsService() {
      return new InMemoryUserDetailsManager(
        User.withUsername("admin")
        .password("{noop}admin123")
        .roles("USER")
        .build()
      );
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
