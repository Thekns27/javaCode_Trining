package org.example.csrfthymeleafdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.cors(c->{
            CorsConfiguration config = new CorsConfiguration();
            config.addExposedHeader("*");
            config.setAllowedOrigins(List.of("http://localhost:5173"));
            config.setAllowCredentials(true);
            config.setAllowedMethods(List.of("*"));
            config.addAllowe

        };




        http.authorizeHttpRequests(c->
                c.anyRequest()
                        .permitAll());
        return http.build();
    }
}
