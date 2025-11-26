package org.example.authorizationbydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        var vds = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("john")
                .password("12345")
                .roles("READ")
                .build();
        var user2 = User.withUsername("mary")
                .password("12345")
                .roles("WRITE")
                .build();
            vds.createUser(user1);
            vds.createUser(user2);
            return vds;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
            http.httpBasic(Customizer.withDefaults());
            http.authorizeHttpRequests(c-> {
                c.requestMatchers("/home").permitAll();
                c.requestMatchers("/products/**").hasRole("READ");
                c.requestMatchers("/store/**").hasRole("WRITE");
                c.anyRequest().authenticated();
            });
            return http.build();
    }
}
