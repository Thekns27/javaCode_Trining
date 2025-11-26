package org.example.methodsecuritydemo.config;


import org.apache.tomcat.util.http.parser.Authorization;
import org.example.methodsecuritydemo.filter.CsrfLoggerFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true,securedEnabled = true)
public class SecurityConfig {
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
//        http.addFilterAfter(new CsrfLoggerFilter(), CsrfFilter.class);
        http.csrf(c->c.disable());
        http.authorizeHttpRequests(c->
//                c.requestMatchers("/home")
//                        .permitAll()
//                        .anyRequest().authenticated());

                c.anyRequest().permitAll());
        return http.build();

    }
    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("mary")
                .password("12345")
                .roles("USER")
                .build();

        uds.createUser(user1);
        uds.createUser(user2);
        return uds;

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
