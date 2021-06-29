package ru.hedin.modelka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig
        implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("index");
        registry.addViewController("/main")
                .setViewName("main");
        registry.addViewController("/login")
                .setViewName("login");

    }

   @Override
 //  @Bean

    public void addCorsMappings(CorsRegistry registry) {




        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("POST","GET")
                .allowedHeaders("*")
              //  .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                //        "Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true).maxAge(3600);

        ;

    }

//
//        @Bean
//                @Override
//                public void addCorsMappings(CorsRegistry registry) {
//                    registry.addMapping("/**").allowedMethods("POST");
//                }
            };
