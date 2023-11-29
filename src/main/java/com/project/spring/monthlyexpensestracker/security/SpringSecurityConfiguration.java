package com.project.spring.monthlyexpensestracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;


@Configuration
public class SpringSecurityConfiguration {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager createUserDetails(){


        UserDetails userDetails = getUserDetails("venugopal","vg@123");
        UserDetails userDetails2 = getUserDetails("venki","venky@123");
        UserDetails userDetails3 = getUserDetails("admin","admin");

        return new InMemoryUserDetailsManager(userDetails,userDetails2,userDetails3);
    }

    public  UserDetails getUserDetails(String username, String password) {
        Function<String,String> passwordEncoder=input->passwordEncoder().encode(input);
        UserDetails userDetails= User.builder().
                passwordEncoder(passwordEncoder).username(username).password(password).
                roles("ADMIN").build();
        return userDetails;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }



}
