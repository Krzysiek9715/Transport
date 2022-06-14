package com.example.projektkoncowy.security;

import com.example.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ADMIN","DRIVER")
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers("/loads/**").hasAuthority("ADMIN")
                .antMatchers("/cars/**").hasAuthority("ADMIN")
                .antMatchers("/drivers/**").hasAuthority("ADMIN")
                .antMatchers("/driverData/**").hasAnyAuthority("ADMIN","DRIVER")
                .and()
                .formLogin()
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                .logout().permitAll();
    }
}
