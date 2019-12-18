package server.config;

import server.servlet.HelloWorldServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.util.HelloWorldBeanUtil;

@Configuration
public class AppConfig {
    @Bean
    public ServletRegistrationBean socketServlet(){
        return new ServletRegistrationBean(new HelloWorldServlet(), "/ws/helloworld");
    }

    @Bean
    public HelloWorldBeanUtil helloWorldBeanUtil() {
        return new HelloWorldBeanUtil();
    }
}
