package ru.hedin.modelka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class Application
{
    public static void main(String[] args){
        SpringApplication.run( Application.class, args );

/*
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/*")
                            .allowedOrigins("http://localhost:8080")
                            .allowedMethods("POST","GET")
               //             .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
              //                      "Access-Control-Request-Headers")
                            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                      //      .allowCredentials(true).maxAge(3600);


                    ;
                }
            };
*/
        };

};
