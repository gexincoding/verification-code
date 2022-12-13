package com.ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author xialinrui
 */
@SpringBootApplication
public class VerificationCodeApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VerificationCodeApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(VerificationCodeApplication.class, args);
    }

}
