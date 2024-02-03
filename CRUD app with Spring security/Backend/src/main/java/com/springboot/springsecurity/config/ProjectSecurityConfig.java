package com.springboot.springsecurity.config;

import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultsecurityFilterchain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/account/my-account").authenticated()
                .antMatchers("/api/v1/loan/my-loan").authenticated()
                .antMatchers("/api/v1/notice/my-notice","/api/v1/login/register").permitAll()
                .and().formLogin().and().httpBasic();
        return httpSecurity.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("1234")
//                .authorities("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin);
//    }
//
//    @Bean
//    public UserDetailsService userDetailsServicee(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
