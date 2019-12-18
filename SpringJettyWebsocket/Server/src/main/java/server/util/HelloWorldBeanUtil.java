package server.util;

import server.service.HelloWorldService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorldBeanUtil implements ApplicationContextAware {

    private static ApplicationContext appCxt;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCxt = applicationContext;
    }

    public static HelloWorldService getHelloWorldService() throws BeansException {
        return (HelloWorldService) appCxt.getAutowireCapableBeanFactory().getBean("helloWorldSvc");
    }
}