package ru.hedin.modelka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
//@EnableWebSecurity (debug = true)
/// give 2 bean  AuthenticationManager - runtime @EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan
@ImportResource("classpath:security.xml")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {


//        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
//
//
//        http.formLogin().defaultSuccessUrl("/username", true);
        //       http.authorizeRequests()
        //               .anyRequest().authenticated()
        //               .and().httpBasic();


/*

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/log").permitAll()
                .antMatchers("/username").permitAll()
            .anyRequest().authenticated()

                .antMatchers("/test/admin").hasRole("ROLE_ADMIN")
                .antMatchers("/test/gm").hasRole("ROLE_GM")
                .antMatchers("/test/user").hasRole("ROLE_USER")
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and().httpBasic();
*/

    }


//   @Bean


/*
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
*/

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            .antMatchers("/").permitAll()
////            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//            .logout()
//            .permitAll();
//    }
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}