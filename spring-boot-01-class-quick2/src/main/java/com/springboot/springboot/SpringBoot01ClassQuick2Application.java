package com.springboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:beans.xml"}) //将这一行注释掉，使用springboot推荐的方法，见config/MyAppConfig.java
@SpringBootApplication
public class SpringBoot01ClassQuick2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01ClassQuick2Application.class, args);
    }
}
