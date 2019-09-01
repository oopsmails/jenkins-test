package com.oopsmails.springboot2.app.all.backendmock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;

@SpringBootApplication
public class SpringBootBackendMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBackendMockApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/backendmock/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
            }
        };
    }

    /**
     * Not really using, just for demo example purpose here.
     */
    @RestController
    class FileResource {

        @GetMapping(path = "/api/files", produces = MediaType.TEXT_PLAIN_VALUE)
        public ResponseEntity<String> getFile() {
            String exportedContent = "Hello, World!";
            String filename = "my-file.txt";
            HttpHeaders headers = new HttpHeaders();
            headers.setAccessControlExposeHeaders(Collections.singletonList("Content-Disposition"));
            headers.set("Content-Disposition", "attachment; filename=" + filename);
            return new ResponseEntity<>(exportedContent, headers, HttpStatus.OK);
        }

    }

}
