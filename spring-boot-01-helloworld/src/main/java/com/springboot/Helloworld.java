package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot 应用
 */
@SpringBootApplication
public class Helloworld {
    public static void main(String[] args){
        SpringApplication.run(Helloworld.class,args);
    }
}
