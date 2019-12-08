package com.imooc;

import com.imooc.security.Lala;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 何国锋
 * @date 2019-12-01 19:08
 */
@SpringBootApplication(scanBasePackages = "com.imooc", exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan(basePackages = "com.imooc.web.controller")
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
        Lala.main(args);
    }
}
