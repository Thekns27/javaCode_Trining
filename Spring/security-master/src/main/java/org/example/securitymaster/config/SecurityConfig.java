package org.example.securitymaster.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity(securedEnabled = true,jsr250Enabled = true)
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private final UserDetailsService userDetailsService;
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider=
                new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
   // @Bean
    public UserDetailsService userDetailsService(){
        var john = User.withUsername("john")
                .password("john")
                .roles("SUPER_ADMIN")
                .build();
        var emma = User.withUsername("emma")
                .password("emma")
                .roles("EMPLOYEES_ADMIN")
                .build();
        var william = User.withUsername("william")
                .password("william")
                .roles("DEPARTMENTS_PAG_VIEW","DEPARTMENTS_READ","DEPARTMENTS_CREATE")
                .build();
        var lucas = User.withUsername("lucas")
                .password("lucas")
                .roles("CUSTOMERS_PAG_VIEW", "CUSTOMERS_READ")
                .build();
        var tom = User.withUsername("tom")
                .password("tom")
                .roles()
                .build();
        return new InMemoryUserDetailsManager(john,emma,william,lucas,tom);
    }
    @Bean
    public SecurityFilterChain
    securityFilterChain(HttpSecurity http)throws Exception{
        http.formLogin(c ->{
            c.loginPage("/login").permitAll();
            c.defaultSuccessUrl("/home");
        });
        http.logout(c ->{
            c.logoutUrl("/logout").permitAll();
            c.logoutSuccessUrl("/login");
        });
        http.csrf( c -> c.disable());
        http.authenticationProvider(daoAuthenticationProvider());
        http.authorizeHttpRequests( c ->{
            c.requestMatchers("/home","/","/register","/bootstrap/**").permitAll();
//            c.requestMatchers("/customers").hasAnyRole("SUPER_ADMIN",
//                    "CUSTOMERS_PAG_VIEW", "CUSTOMERS_READ");
//            c.requestMatchers("/customer-create","/delete-customer")
//                    .hasRole("SUPER_ADMIN");
//            c.requestMatchers("/employees/**").hasAnyRole("EMPLOYEES_ADMIN","SUPER_ADMIN");
//            c.requestMatchers("/departmentse","departments/create")
//                            .hasAnyRole("DEPARTMENTS_PAG_VIEW", "DEPARTMENTS_READ",
//                                    "DEPARTMENTS_CREATE","SUPER_ADMIN");
//            c.requestMatchers("/departments/delete/*").hasRole("SUPER_ADMIN");
            c.anyRequest().authenticated();
        });
        return http.build();
    }
}
