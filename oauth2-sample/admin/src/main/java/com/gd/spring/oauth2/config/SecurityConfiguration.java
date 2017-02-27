package com.gd.spring.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/lib/**").permitAll()
                .antMatchers("/index.html", "/unauthenticated.html", "/").permitAll()
                .anyRequest().hasRole("ADMIN")
                .and()
                .csrf().disable();
        // @formatter:on
    }
}