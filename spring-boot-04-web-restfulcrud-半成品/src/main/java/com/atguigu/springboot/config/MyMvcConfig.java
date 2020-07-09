package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//使用WebMvcConfigurer可以来扩展SpringMVC的功能
//@EnableWebMvc //全面接管springboot,也就是它里面的所有配置都需要我们自己来配
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<>(){

            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/atguigu").setViewName("success");
    }

    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        return new MyMvcConfig(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/user/login","/asserts/**","/webjars/**");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
