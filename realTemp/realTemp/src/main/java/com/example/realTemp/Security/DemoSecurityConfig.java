//package com.example.realTemp.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class DemoSecurityConfig {
//
//    @Bean
//    public InMemoryUserDetailsManager User(){
//
//        UserDetails john = User.builder()
//                .username("satyam")
//                .password("{noop}test001")
//                .roles("Employee")
//                .build();
//
//        UserDetails cena = User.builder()
//                .username("user2")
//                .password("{noop}test002")
//                .roles("Manager")
//                .build();
//
//        return new InMemoryUserDetailsManager(john);
//    }
//
////    @Bean
//
//
//
//}
