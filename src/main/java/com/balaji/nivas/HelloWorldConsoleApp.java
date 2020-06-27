package com.balaji.nivas;

/**
 * Hello world!
 *
 */

import com.balaji.nivas.beans.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class HelloWorldConsoleApp
{
    @Autowired
    private Hello helloBean;

    @Autowired
    private HelloWorldConsoleApp helloWorldConsoleApp;

    public void bootConsole(String value) {
        if(null != value)
            helloBean.setName(value);
        System.out.println("The bean prints : Hello " + helloBean.getName());
    }

    public static void main( String[] args ) {
        SpringApplication.run(HelloWorldConsoleApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                System.out.println("Let's inspect the beans provided by Spring Boot:");

                String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (String beanName : beanNames) {
                    System.out.println(beanName);
                }
                String value = null;
                if(null != args && args.length > 0) {
                    value = args[0];
                }
                helloWorldConsoleApp.bootConsole(value);
            }
        };
    }
}
